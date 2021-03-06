/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.management.datalake.store.uploader;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests that target the {@link UploadSegmentMetadata} class.
 */
public class UploadSegmentMetadataTests {
    /**
     * Tests that segment count calculation works (it's hard to verify correctness without having access to the data that the base class has,
     * so we'll just check the boundary conditions, that it's monotonically increasing and that it doesn't throw exceptions for various inputs.
     */
    @Test
    public void UploadMetadata_CalculateSegmentCount()
    {
        try {
            UploadSegmentMetadata.CalculateSegmentCount(-1);
            Assert.assertTrue("CalculateSegmentCount should have failed for invalid count but it succeeded!", false);
        }
        catch (IllegalArgumentException ex) {
            // do nothing, this is expected
        }


        Assert.assertEquals(0, UploadSegmentMetadata.CalculateSegmentCount(0));

        long maxLength = 100 * (long)Math.pow(2, 40);//100 TB
        long increment = 10 * (long)Math.pow(2, 30); //10GB
        int lastValue = 0;
        for (long length = (long)Math.pow(2, 20); length < maxLength; length += increment)
        {
            int value = UploadSegmentMetadata.CalculateSegmentCount(length);
            Assert.assertTrue("Function is not monotonically increasing", lastValue <= value);
            lastValue = value;
        }
    }

    /**
     * Tests the correct calculation for a typical segment length.
     */
    @Test
    public void UploadSegmentMetadata_CalculateTypicalSegmentLength()
    {
        try {
            UploadSegmentMetadata.CalculateSegmentLength(1000, -1);
            Assert.assertTrue("CalculateSegmentLength should have failed for invalid length but it succeeded!", false);
        }
        catch (IllegalArgumentException ex) {
            // do nothing, expected
        }

        int maxSegmentCount = 16536;
        long fileLength = (long)Math.pow(2, 30); // see comment below about actually making this larger than Int32.MaxValue
        long segmentLength;

        for (int segmentCount = 1; segmentCount < maxSegmentCount; segmentCount++)
        {
            segmentLength = UploadSegmentMetadata.CalculateSegmentLength(fileLength, segmentCount);

            //the next two asserts verify that the value calculated will split the input file into a balanced set of segments;
            //all the segments should have the same length, except the last one which may have less than that (but never more).
            //a quick heuristic to verify this is: (SegmentLength-1)*SegmentCount < FileLength <= SegmentLength*SegmentCount
            Assert.assertTrue("SegmentLength * SegmentCount must be at least the length of the input file", segmentLength * segmentCount >= fileLength);
            Assert.assertTrue("(SegmentLength - 1) * SegmentCount must be smaller than the length of the input file", (segmentLength - 1) * segmentCount < fileLength);
        }

        // test segmentCount == fileLength;
        segmentLength = UploadSegmentMetadata.CalculateSegmentLength(fileLength, (int)fileLength); //for this to work, FileLength must be less than In32.MaxValue
        Assert.assertEquals(1, segmentLength);

        // test that if segment count = 0 then the return value is 0.
        Assert.assertEquals(
                0,
                UploadSegmentMetadata.CalculateSegmentLength(fileLength, 0));
    }

    /**
     * Tests the correct calculation for a particular segment length (ending vs non-ending).
     */
    @Test
    public void UploadSegmentMetadata_CalculateParticularSegmentLength()
    {

        UploadMetadata lengthOf10 = new UploadMetadata();
        lengthOf10.FileLength = 10;
        lengthOf10.SegmentCount = 5;
        lengthOf10.SegmentLength = 2;
        UploadMetadata lengthOfNegative10 = new UploadMetadata();
        lengthOfNegative10.FileLength = -10;
        lengthOfNegative10.SegmentCount = 5;
        lengthOfNegative10.SegmentLength = 2;
        UploadMetadata lengthOf100 = new UploadMetadata();
        lengthOf100.FileLength = 100;
        lengthOf100.SegmentCount = 2;
        lengthOf100.SegmentLength = 2;
        UploadMetadata lengthOf100SegmentCount5 = new UploadMetadata();
        lengthOf100SegmentCount5.FileLength = 100;
        lengthOf100SegmentCount5.SegmentCount = 5;
        lengthOf100SegmentCount5.SegmentLength = 26;
        //verify bad inputs
        try {
            UploadSegmentMetadata.CalculateSegmentLength(-1, lengthOf10);
            Assert.assertTrue("CalculateSegmentLength should have failed for invalid segment number but it succeeded!", false);
        }
        catch (IndexOutOfBoundsException ex) {
            // do nothing, expected
        }

        try {
            UploadSegmentMetadata.CalculateSegmentLength(100, lengthOf10);
            Assert.assertTrue("CalculateSegmentLength should have failed for invalid segment number but it succeeded!", false);
        }
        catch (IndexOutOfBoundsException ex) {
            // do nothing, expected
        }

        try {
            UploadSegmentMetadata.CalculateSegmentLength(1, lengthOfNegative10);
            Assert.assertTrue("CalculateSegmentLength should have failed for invalid segment number but it succeeded!", false);
        }
        catch (IllegalArgumentException ex) {
            // do nothing, expected
        }

        try {
            UploadSegmentMetadata.CalculateSegmentLength(1, lengthOf100);
            Assert.assertTrue("CalculateSegmentLength should have failed for invalid segment number but it succeeded!", false);
        }
        catch (IllegalArgumentException ex) {
            // do nothing, expected
        }

        try {
            UploadSegmentMetadata.CalculateSegmentLength(1, lengthOf100SegmentCount5);
            Assert.assertTrue("CalculateSegmentLength should have failed for invalid segment number but it succeeded!", false);
        }
        catch (IllegalArgumentException ex) {
            // do nothing, expected
        }

        //test various scenarios with a fixed file length, and varying the segment count from 1 to the FileLength

        int FileLength = 16 * (int)Math.pow(2, 20);//16MB

        for (int segmentCount = 1; segmentCount <= FileLength; segmentCount += 1024)
        {
            long typicalSegmentLength = UploadSegmentMetadata.CalculateSegmentLength(FileLength, segmentCount);

            UploadMetadata uploadMetadata = new UploadMetadata();
            uploadMetadata.FileLength=FileLength;
            uploadMetadata.SegmentCount=segmentCount;
            uploadMetadata.SegmentLength=typicalSegmentLength;

            long firstSegmentLength = UploadSegmentMetadata.CalculateSegmentLength(0, uploadMetadata);
            long lastSegmentLength = UploadSegmentMetadata.CalculateSegmentLength(segmentCount - 1, uploadMetadata);

            Assert.assertEquals(typicalSegmentLength, firstSegmentLength);
            if (segmentCount == 1)
            {
                Assert.assertEquals(firstSegmentLength, lastSegmentLength);
            }

            long reconstructedFileLength = typicalSegmentLength * (segmentCount - 1) + lastSegmentLength;
            Assert.assertEquals(FileLength, reconstructedFileLength);
        }
    }
}

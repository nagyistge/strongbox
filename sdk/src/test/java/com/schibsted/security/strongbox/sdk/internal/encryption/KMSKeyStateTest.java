/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Schibsted Products & Technology AS
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.schibsted.security.strongbox.sdk.internal.encryption;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author kvlees
 */
public class KMSKeyStateTest {
    @Test
    public void testFromString() throws Exception {
        assertEquals(KMSKeyState.fromString("Enabled"), KMSKeyState.ENABLED);
        assertEquals(KMSKeyState.fromString("Disabled"), KMSKeyState.DISABLED);
        assertEquals(KMSKeyState.fromString("PendingDeletion"), KMSKeyState.PENDING_DELETION);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFromStringInvalidState() throws Exception {
        KMSKeyState.fromString("Invalid");
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(KMSKeyState.fromString("Enabled").toString(), "Enabled");
        assertEquals(KMSKeyState.fromString("Disabled").toString(), "Disabled");
        assertEquals(KMSKeyState.fromString("PendingDeletion").toString(), "PendingDeletion");
    }
}

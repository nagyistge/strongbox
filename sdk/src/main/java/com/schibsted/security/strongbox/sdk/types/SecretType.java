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

package com.schibsted.security.strongbox.sdk.types;

import java.util.HashMap;
import java.util.Map;

/**
 * @author stiankri
 */
public enum SecretType {
    // TODO: define types
    //ACCESS_TOKEN, PASSPHRASE, PUBLIC, PRIVATE, OPAQUE
    OPAQUE("opaque", (byte)0);

    static Map<String, SecretType> nameMap = new HashMap<>();
    static Map<Byte, SecretType> valueMap = new HashMap<>();
    static {
        for (SecretType type : values()) {
            valueMap.put(type.value, type);
            nameMap.put(type.name, type);
        }
    }

    private final byte value;
    private final String name;

    SecretType(String name, byte value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name;
    }

    public byte asByte() {
        return value;
    }

    public static SecretType fromByte(byte value) {
        return valueMap.get(value);
    }
}

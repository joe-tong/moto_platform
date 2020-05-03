package com.tulin.common.base.enumeration;

/**
 * TPP
 * @author User
 * @param <C>
 */
public interface BaseEnum<C> {
    C code();

    static <T extends BaseEnum<?>> T parse(Class<T> enumType, Object code) {
        T[] enums = enumType.getEnumConstants();
        BaseEnum[] var3 = enums;
        int var4 = enums.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            T t = (T) var3[var5];
            if (t.code().equals(code)) {
                return t;
            }
        }

        return null;
    }
}

package travelcompany.common.business.repo.memory;

import java.util.Comparator;

public final class CommonComparatorHolder {
    private static Comparator<String> comparatorForNullableStrings = (s1, s2) -> {
        if (s1 == null && s2 == null) {
            return 0;
        } else if (s1 != null) {
            return s1.compareTo(s2);
        } else {
            return -1;
        }
    };

    private static Comparator<Integer> comparatorForNullableIntegers = (i1, i2) -> {
        if (i1 == null && i2 == null) {
            return 0;
        } else if (i1 != null) {
            return i1.compareTo(i2);
        } else {
            return -1;
        }

    };

    private static Comparator<Boolean> comparatorForNullableBooleans = (b1, b2) -> {
        if (b1 == null && b2 == null) {
            return 0;
        } else if (b1 != null) {
            return b1.compareTo(b2);
        } else {
            return -1;
        }
    };

    private CommonComparatorHolder() {}

    public static Comparator<String> getComparatorForNullableStrings() {
        return comparatorForNullableStrings;
    }

    public static Comparator<Integer> getComparatorForNullableIntegers() {
        return comparatorForNullableIntegers;
    }

    public static Comparator<Boolean> getComparatorForNullableBooleans() {
        return comparatorForNullableBooleans;
    }
}

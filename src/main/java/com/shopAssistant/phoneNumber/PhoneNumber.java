package com.shopAssistant.phoneNumber;

// TODO: this class needs to be updated and improved
public final class PhoneNumber {
    private Integer countryCode;
    private Long number;

    private PhoneNumber(Integer countryCode, Long number) {
        this.countryCode = countryCode;
        this.number = number;
    }

    public static PhoneNumber create(String phoneNumber) {
        int phoneNumberLength;
        Long onlyNumber;
        Integer countryCode = null;
        Integer countryCodeStartIndex = null;

        if (phoneNumber == null)
            throw new IllegalArgumentException("Phone number is not initialized");

        phoneNumber = phoneNumber.trim();
        phoneNumberLength = phoneNumber.length();

        if (phoneNumberLength < 8)
            throw new IllegalArgumentException("Phone number is too short");

        onlyNumber = Long.parseLong(phoneNumber.substring(phoneNumberLength - 9, phoneNumberLength - 1));

        switch (phoneNumberLength) {
            case 11 :
                countryCodeStartIndex = 0;
                break;
            case 12 :
                countryCodeStartIndex = 1;
                break;
        }

        if (countryCodeStartIndex != null) {
            countryCode = Integer.valueOf(phoneNumber.substring(countryCodeStartIndex, countryCodeStartIndex + 3));
        }

        return new PhoneNumber(countryCode, onlyNumber);
    }

    public long getOnlyNumber() {
        return number.longValue();
    }
}

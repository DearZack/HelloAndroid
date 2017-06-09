package io.github.dearzack.helloandroid.bean;

/**
 * Created by Zack on 2017/6/9.
 */

public class User {
    private final String mFirstName;
    private final String mLastName;
    private final String mGender;
    private final int mAge;
    private final String mPhoneNo;

    private User(UserBuilder userBuilder) {
        mFirstName = userBuilder.firstName;
        mLastName = userBuilder.lastName;
        mGender = userBuilder.gender;
        mAge = userBuilder.age;
        mPhoneNo = userBuilder.phoneNo;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public String getmGender() {
        return mGender;
    }

    public int getmAge() {
        return mAge;
    }

    public String getmPhoneNo() {
        return mPhoneNo;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private String gender;
        private int age;
        private String phoneNo;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

package io.github.dearzack.helloandroid.bean;

/**
 * Created by Zack on 2017/6/9.
 */

public class UserCreateByInnerBuilder {
    private final String mFirstName;
    private final String mLastName;
    private final String mGender;
    private final int mAge;
    private final String mPhoneNo;

    private UserCreateByInnerBuilder(Builder builder) {
        mFirstName = builder.mFirstName;
        mLastName = builder.mLastName;
        mGender = builder.mGender;
        mAge = builder.mAge;
        mPhoneNo = builder.mPhoneNo;
    }


    public static final class Builder {
        private String mFirstName;
        private String mLastName;
        private String mGender;
        private int mAge;
        private String mPhoneNo;

        public Builder() {
        }

        public Builder mFirstName(String val) {
            mFirstName = val;
            return this;
        }

        public Builder mLastName(String val) {
            mLastName = val;
            return this;
        }

        public Builder mGender(String val) {
            mGender = val;
            return this;
        }

        public Builder mAge(int val) {
            mAge = val;
            return this;
        }

        public Builder mPhoneNo(String val) {
            mPhoneNo = val;
            return this;
        }

        public UserCreateByInnerBuilder build() {
            return new UserCreateByInnerBuilder(this);
        }
    }
}

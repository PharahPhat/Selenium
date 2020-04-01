package com.sandata.models;

import com.sandata.common.Constant;

public class DataModel {
    public String id;
    public String data_type;
    public String input;
    public int maxLength;
    public boolean expected;

    public Constant.DataType getDataType(){
        if(data_type.equals(Constant.DataType.alphabetic.toString()))
            return Constant.DataType.alphabetic;
        else if(data_type.equals(Constant.DataType.alphaNumeric.toString()))
            return Constant.DataType.alphaNumeric;
        else if(data_type.equals(Constant.DataType.numeric.toString()))
            return Constant.DataType.numeric;

        return Constant.DataType.userInput;
    }

}

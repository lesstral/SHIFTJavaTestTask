package filterapp.FileService;

import java.util.ArrayList;
import java.util.List;

import filterapp.utils.IPrintable;

public class ParsedDataDTO {
    @IPrintable(name="integers")
    public List<Long> intList = new ArrayList<Long>();
    @IPrintable(name="floats")
    public List<Double> floatList = new ArrayList<Double>();
    @IPrintable(name="strings")
    public List<String> stringList = new ArrayList<String>();
}
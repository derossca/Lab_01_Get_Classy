public class Product
{
    private String ID = "";
    private String name = "";
    private String descript = "";
    private double cost = 0;

    //Constructors
    public Product(String ID, String name, String descript, double cost) {
        this.ID = ID;
        this.name = name;
        this.descript = descript;
        this.cost = cost;
    }

    //Getters and Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    //toCSV data format
    public String toCSVDataRecord()
    {
        return this.ID + "," + this.name + "," + this.descript + "," + this.cost;
    }

    public String toJSONRecord() {
        String retString = "";
        char DQ = '\u0022'; //Assign the double quote char to a variable for readability
        retString = "{" + DQ + "ID" + DQ + ":" + DQ + this.ID + DQ + "," +
                DQ + "name" + DQ + ":" + DQ + this.name + DQ + "," +
                DQ + "description" + DQ + ":" + DQ + this.descript + DQ + "," +
                DQ + "cost" + DQ + ":" + DQ + this.cost + DQ + "}";
        return retString;
    }

    public String toXMLRecord() {
        String retString = "";
        retString = "<Product>";
        retString += "<ID>" + this.ID + "</ID>";
        retString += "<name>" + this.name + "</name>";
        retString += "<description>" + this.descript + "</description>";
        retString += "<cost>" + this.cost + "</cost>";

        return retString;
    }

    //toString()
    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", descript='" + descript + '\'' +
                ", cost=" + cost +
                '}';
    }
}

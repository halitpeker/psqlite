package pekerteknoloji.com.psqlite;
/*
 * Halit PEKER
 */

public class TableColumn {
    private String name;
    private String type;
    private String property;

    public TableColumn(String name, String type, String property) {

        this.name = name;
        this.type = type;
        this.property = property;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}

package edu.hw3.Task6;

public class Stock {

    private final String company;

    private Integer value;

    public Stock(Integer value, String company) {
        this.value = value;
        this.company = company;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getCompany() {
        return company;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Stock stock = (Stock) o;

        if (company != null ? !company.equals(stock.company) : stock.company != null) {
            return false;
        }
        return value != null ? value.equals(stock.value) : stock.value == null;
    }

    @Override
    public int hashCode() {
        int result = company != null ? company.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return "Stock{"
            + "company='" + company + '\''
            + ", value=" + value
            + '}';
    }
}

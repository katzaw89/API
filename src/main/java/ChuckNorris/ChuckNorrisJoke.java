package ChuckNorris;

import java.util.Objects;

public class ChuckNorrisJoke {
    private String category;
    private String icon_url;
    private String id;
    private String url;
    private String value;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChuckNorrisJoke that = (ChuckNorrisJoke) o;
        return Objects.equals(category, that.category) &&
                Objects.equals(icon_url, that.icon_url) &&
                Objects.equals(id, that.id) &&
                Objects.equals(url, that.url) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, icon_url, id, url, value);
    }

    @Override
    public String toString() {
        return "ChuckNorrisJoke{" +
                "value='" + value + '\'' +
                '}';
    }
}



package ChuckNorris;

import java.util.Objects;



public class Joke {

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
        Joke joke = (Joke) o;
        return category.equals(joke.category) &&
                icon_url.equals(joke.icon_url) &&
                id.equals(joke.id) &&
                url.equals(joke.url) &&
                value.equals(joke.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, icon_url, id, url, value);
    }

    @Override
    public String toString() {
        return "Joke{" +
                "value='" + value + '\'' +
                '}';
    }
}

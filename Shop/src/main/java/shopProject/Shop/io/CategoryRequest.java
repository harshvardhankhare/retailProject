package shopProject.Shop.io;



public class CategoryRequest {

    private String name;
    private String description;
    private String bgColor;
    private String imgUrl;

    // No-arg constructor
    public CategoryRequest() {
    }

    // All-arg constructor
    public CategoryRequest(String name, String description, String bgColor, String imgUrl) {
        this.name = name;
        this.description = description;
        this.bgColor = bgColor;
        this.imgUrl = imgUrl;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    // Optional: toString
    @Override
    public String toString() {
        return "CategoryRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", bgColor='" + bgColor + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}

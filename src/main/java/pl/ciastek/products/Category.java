package pl.ciastek.products;

public enum Category {

    FOOD("Art.spozywcze", "spozywcze"),
    HOME("Art.gosp.domowego", "domowe"),
    OTHER("Inne", "inne")
    ;

    private final String fullDescription;
    private final String shortDeDescription;

    Category(String FullDescription, String shortDeDescription) {
        this.fullDescription = FullDescription;
        this.shortDeDescription = shortDeDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public String getShortDeDescription() {
        return shortDeDescription;
    }
}

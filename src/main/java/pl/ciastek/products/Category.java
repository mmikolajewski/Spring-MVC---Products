package pl.ciastek.products;

public enum Category {

    food("Art.spozywcze", "spozywcze"),
    home("Art.gosp.domowego", "domowe"),
    other("Inne", "inne")
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

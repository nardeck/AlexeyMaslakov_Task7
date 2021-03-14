public enum ModelOfProduct {

    OMEN_17_w211ur(" OMEN_17_w211ur3760", 1300),
    Spectre_13_v103ur("Spectre_13_v103ur2700", 1255),
    EliteBook_840_G1("EliteBook_840_G11200", 2300),
    Probook_450_g3("Probook_450_g3 1300", 1555),
    Elite_book_folio_g1("Elite_book_folio_g1", 1230),
    Envy_6("Envy_6", 2500),
    Pavilion_x360_11("Pavilion_x360_11", 1200),
    Pavilion_DV7_6053er("Pavilion_DV7_6053er", 1300),
    Notebook_17_x013ur("Notebook_17_x013ur", 1280),
    EliteBook_1030("EliteBook_1030", 2100),
    ProBook_4530s("ProBook_4530s", 1500),
    Pavilion_dv6_6c60er_LinenWhite("Pavilion_dv6_6c60er_LinenWhite", 1600),
    ProBook_655_G3("ProBook_655_G3", 1700),
    Pavilion_17_ab020ur("Pavilion_17_ab020ur", 1800),
    ENVY_15_as006ur("ENVY_15_as006ur", 1900),
    Pavilion_X2("Pavilion_X2", 2200);


    private final int price;
    private String model;


    ModelOfProduct(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ModelOfProduct - " +
                model +
                ", price-" + price;
    }
}
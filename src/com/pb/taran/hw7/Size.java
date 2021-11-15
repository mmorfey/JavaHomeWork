package com.pb.taran.hw7;

public enum Size {
    XXS ("Детский размер", 32),
    XS ("Взрослый размер", 34),
    S ("Взрослый размер", 36),
    M ("Взрослый размер", 38),
    L ("Взрослый размер", 40);

    private final String description;
    private final int euroSize;

    Size(String description, int euroSize) {
        this.description = description;
        this.euroSize = euroSize;
    }

    public String getDescription() {
        return description;
    }

    public int getEuroSize() {
        return euroSize;
    }


//    public void getDescription() {
//        if (size == XXS) {
//            System.out.println("Детский размер");
//        }
//        System.out.println("Взрослый размер");
//
//    }
//
//    public void getEuroSize() {
//
//        switch (size) {
//            case XXS:
//                System.out.println("XXS - размер " + 32);
//                break;
//            case XS:
//                System.out.println("XS - размер " + 34);
//                break;
//            case S:
//                System.out.println("S - размер " + 36);
//                break;
//            case M:
//                System.out.println("M - размер " + 38);
//                break;
//            case L:
//                System.out.println("L - размер " + 40);
//                break;
//        }
//    }
}

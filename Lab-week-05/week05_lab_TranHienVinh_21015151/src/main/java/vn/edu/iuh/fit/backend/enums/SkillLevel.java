package vn.edu.iuh.fit.backend.enums;

public enum SkillLevel {
    BEGINNER((byte) 1),
    INTERMEDIATE((byte) 2),
    ADVANCED((byte) 3),
    PROFESSIONAL((byte) 4),
    MASTER((byte) 5);


    private byte level;

    SkillLevel(byte level) {
        this.level = level;
    }

    public byte getLevel() {
        return level;
    }

//    public static SkillLevel fromByte(byte level) {
//        for (SkillLevel skillLevel : SkillLevel.values()) {
//            if (skillLevel.getLevel() == level) {
//                return skillLevel;
//            }
//        }
//        throw new IllegalArgumentException("Unknown level: " + level);
//    }
}

package school.sptech.model;

public enum Severidade {
    baixo,
    medio,
    critico;

    public static Severidade string(String value) {
        if (value == null) return null;
        switch (value.toLowerCase()) {
            case "baixo": return baixo;
            case "medio": return medio;
            case "critico": return critico;
            default: return null;
        }
    }
}
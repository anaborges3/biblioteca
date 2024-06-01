package br.com.biblioteca;

public enum Categoria {
    FICCAO,
    NAO_FICCAO,
    CIENCIA,
    HISTORIA,
    TECNOLOGIA,
    OUTROS;

    @Override
    public String toString() {
        switch (this) {
            case FICCAO:
                return "Ficção";
            case NAO_FICCAO:
                return "Não Ficção";
            case CIENCIA:
                return "Ciência";
            case HISTORIA:
                return "História";
            case TECNOLOGIA:
                return "Tecnologia";
            case OUTROS:
                return "Outros";
            default:
                return super.toString();
        }
    }
}



package model;

public enum StatusOrcamento {

    AGUARDANDO_CLIENTE("AGUARDANDO_CLIENTE"),
    APROVADO("APROVADO"),
    CANCELADO("CANCELADO");
    
    private final String status;
    
    private StatusOrcamento(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
    
    
    
}

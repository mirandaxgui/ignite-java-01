import java.time.LocalDateTime;

public class Livro {
    private int id;
    private String titulo, autor;
    private boolean disponivel;
    private LocalDateTime dataCadastro, dataAtualizacao;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    
    

    public Livro(int id, String titulo, String autor, boolean disponivel, LocalDateTime dataCadastro) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        this.dataCadastro = dataCadastro;
    }
    public Livro(int id, String titulo, String autor, boolean disponivel, LocalDateTime dataCadastro,
            LocalDateTime dataAtualizacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
    }
    @Override
    public String toString() {
        return "\nId: " + id + ", titulo: " + titulo + ", autor: " + autor + ", disponivel: " + disponivel
                + ", data de cadastro: " + dataCadastro + ", data de atualizacao: " + dataAtualizacao + "\n";
    }
    
}
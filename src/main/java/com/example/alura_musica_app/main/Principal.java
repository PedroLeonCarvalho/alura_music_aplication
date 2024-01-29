package com.example.alura_musica_app.main;


import com.example.alura_musica_app.model.Artista;
import com.example.alura_musica_app.model.Genero;
import com.example.alura_musica_app.model.Musica;
import com.example.alura_musica_app.repository.ArtistaRepository;
import com.example.alura_musica_app.service.ConsultaChatGPT;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private final ArtistaRepository repositorio;
    private Scanner leitura = new Scanner(System.in);

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {

        var opcao = -1;
        while (opcao != 0) {

            var menu = """
                    Escolha as opções abaixo:
                             1-Cadastrar artista
                             2-Cadastrar musica
                             3-Listar musicas cadastradas
                             4-Buscar musica por Artista
                             5-Pesquisar discografia de um artista
                             0-Sair""";
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();


            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisaDadosDoArtista();
                    break;
            }
        }
    }


    private void pesquisaDadosDoArtista() {
        System.out.println("Quer saber mais sobre qual artista?");
        String texto = leitura.nextLine();
    var resposta = ConsultaChatGPT.obterInformacao(texto);
        System.out.println(resposta.trim());
    }

    private void buscarMusicasPorArtista() {
        System.out.println("Buscar muda de qual artista?");
        String nome = leitura.nextLine();
        List<Musica> musicas = repositorio.buscaMusicaPorArtista(nome);
        musicas.forEach(System.out::println);

    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));

    }

    private void cadastrarMusicas() {
        System.out.println("Cadastrar musica de qual artista?");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nome);
        if(artista.isPresent()) {
            System.out.println("Informe o titulo da musica");
            var tituloMusica = leitura.next();
            Musica musica = new Musica(tituloMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());
        }else {
            System.out.println("Artista nao encontrado");

        }



    }

    private void cadastrarArtistas() {
       var cadastroNovo = "S";
       while (cadastroNovo.equalsIgnoreCase("s")) {

            System.out.println("Digite o nome do artista:");
            String nomeArtista = leitura.nextLine();
            System.out.println("Digite se é Popular, Instrumental ou Clássica");
            String genero = leitura.nextLine().toUpperCase();
            Genero g = Genero.valueOf(genero);
            Artista artista = new Artista(nomeArtista, g);
            repositorio.save(artista);
           System.out.println("Cadastrar novo artista? (S/N)");
           cadastroNovo = leitura.nextLine();
      }

    }

}


package com.example.alura_musica_app.main;

import com.example.alura_musica_app.model.Artista;
import com.example.alura_musica_app.repository.ArtistaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {


    private Scanner leitura = new Scanner(System.in);

    public void exibeMenu() {

        var opcao = -1;
        while (opcao !=0) {

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
    }

    private void buscarMusicasPorArtista() {
        
    }

    private void listarMusicas() {
        
    }

    private void cadastrarMusicas() {
        
    }

    private void cadastrarArtistas() {
        
    }


}



    //Artistas  - cadastrar
//Musicas - cadastrar e pedir o artista
//Enum Gênero
//Menu 1-Cadastrar artista ( pede pra cadastrar o gênero também fornecendo opções) , 2 -Cd. musicas, 3- Listar musicas ( Aparece musicas e seu artista) 4- buscar musicas por artista ,
 //5-pesqusiar dados sobre um artista(Integra com gpt)- 9 sair


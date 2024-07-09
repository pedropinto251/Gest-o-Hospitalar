package otica.utilizador.apoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import avioes.apoo.app.Aeronave;
import avioes.apoo.app.Aeroporto;
import avioes.apoo.app.Passageiros;
import avioes.apoo.app.Tripulacao;
import avioes.apoo.app.Voo;

/**
 * Funcao que inicia a aplicacao
 *
 */
public class Aplicacao {

    private String nome;
    private String companhia;
    private String LocalizacaoDados = "C:\\aplicacao";

    Scanner ler = new Scanner(System.in);

    ArrayList<Voo> voos = new ArrayList<>();
    ArrayList<Aeronave> aeronaves = new ArrayList<>();
    ArrayList<Aeroporto> aeroportos = new ArrayList<>();
    ArrayList<Tripulacao> tripulantes = new ArrayList<>();
    ArrayList<Passageiros> passageiros = new ArrayList<>();

    /**
     * Funcao que inicia o programa
     */
    public void Iniciar() {
        SelecionarCompanhiaAerea();
        LerFicheirosVoos();
        LerFicheirosPassageiros();
        LerFicheirosAeroportos();
        LerFicheirosAeronaves();
        LerFicheirosTripulantes();
        System.out.println("## Bem vindo ao gestor de aeroportos! ##");
        System.out.println("      |\r\n" + "                       --====|====--\r\n"
                + "                             |  \r\n" + "\r\n" + "                         .-\"\"\"\"\"-. \r\n"
                + "                       .'_________'. \r\n" + "                      /_/_|__|__|_\\_\\\r\n"
                + "                     ;'-._       _.-';\r\n"
                + ",--------------------|    `-. .-'    |--------------------,\r\n"
                + " ``\"\"--..__    ___   ;       '       ;   ___    __..--\"\"``\r\n"
                + "           `\"-// \\\\.._\\             /_..// \\\\-\"`\r\n"
                + "              \\\\_//    '._       _.'    \\\\_//\r\n"
                + "               `\"`        ``---``        `\"`");
        System.out.println(" ");
        System.out.println("## Created by: David Fernandes e Asaph Alves ##");
        System.out.println(" ");
        MenuPrincipal();

    }

    /**
     * Funcao que seleciona a companhia aerea
     */
    public void SelecionarCompanhiaAerea() {
        System.out.println(
                "Ola!, por questoes de seguranca necessitamos saber o nome do utilizador, insira abaixo para verificacao:\n");

        System.out.println("Digite o nome de utilizador:");
        nome = ler.nextLine();

        System.out.println("Qual a companhia aerea?");
        companhia = ler.nextLine();
    }

    /**
     * Funcao que mostra ao utilizador o menu principal
     */
    public void MenuPrincipal() {

        int opcao;
        do {

            System.out.println("");
            System.out.println("## Menu principal ##");
            System.out.println(" ");
            System.out.println("Companhia selecionada: " + companhia);
            System.out.println("Utilizador: " + nome);

            System.out.println("Selecione uma opcao:");

            System.out.println("1 - Voos");
            System.out.println("2 - Passageiros");
            System.out.println("3 - Tripulantes");
            System.out.println("4 - Aeronaves");
            System.out.println("5 - Aeroportos");
            System.out.println("6 - Fechar");

            opcao = ler.nextInt();
            ler.nextLine();

            // chamar a funcao especifica a que o utilizador usar
            switch (opcao) {
                case 1:
                    ApresentarMenuVoo();
                    break;
                case 2:
                    ApresentarMenuPassageiro();
                    break;
                case 3:
                    ApresentarMenuTripulacao();
                    break;
                case 4:
                    MenuAeronaves();
                    break;
                case 5:
                    MenuAeroportos();
                    break;
                case 6:
                    GravarFicheirosVoos();
                    GravarFicheirosPassageiros();
                    GravarFicheirosAeroportos();
                    GravarFicheirosAeronave();
                    GravarFicheirosTripulantes();
                    break;
                default:
                    System.out.println("Escolha desconhecida!");
                    break;
            }
        } while (opcao != 6);
    }

    /**
     * Funcao para apresentar o menu de voo
     */
    public void ApresentarMenuVoo() {

        int opcao;
        System.out.println("## MENU VOOS ##");

        do {

            System.out.println("1 - Listar voos");
            System.out.println("2 - Editar voo");
            System.out.println("3 - Adicionar voo");
            System.out.println("4 - Eliminar voo");
            System.out.println("5 - Voltar ao menu anterior");

            opcao = (ler.nextInt());
            ler.nextLine();
            // chamar a funcao especifica a que o utilizador usar
            switch (opcao) {
                case 1:
                    MenuVooListar();
                    break;
                case 2:
                    EditarVooCompleto();
                    break;
                case 3:
                    AdicionarVoo();
                    break;
                case 4:
                    EliminarVoo();
                    break;
                case 5:
                    MenuPrincipal();

                default:
                    System.out.println("Escolha desconhecida!");

                    break;
            }
        } while (opcao != 5);
    }

    /**
     * Funcao que mostra ao utilizador o menu listar voos
     */
    public void MenuVooListar() {

        int opcao;
        System.out.println("## MENU VOOS - LISTAR ##");

        do {
            System.out.println("1 - Listar voos por datas");
            System.out.println("2 - Listar voos por rotas");
            System.out.println("3 - Listar todos os voos");
            System.out.println("4 - Listar voo por n�mero");
            System.out.println("5 - Voltar ao menu anterior");

            opcao = ler.nextInt();
            ler.nextLine();

            // chamar a funcao especifica a que o utilizador usar
            switch (opcao) {
                case 1:
                    FiltrarVoosPorData();
                    break;
                case 2:
                    FilrarVoosPorRota();
                    break;
                case 3:
                    ListarVoos();
                    break;
                case 4:
                    ListarVoosPorNumero();
                    break;
                case 5:
                    ApresentarMenuVoo();
                    break;
                default:
                    System.out.println("Escolha desconhecida!");
                    break;
            }
        } while (opcao != 5);
    }

    /**
     * Funcao que mostra ao utilizador o menu passageiros
     */
    public void ApresentarMenuPassageiro() {

        int opcao;

        System.out.println("## MENU PASSAGEIROS ##");

        do {
            System.out.println("1 - Listar passageiros");
            System.out.println("2 - Editar passageiro");
            System.out.println("3 - Adicionar passageiro");
            System.out.println("4 - Eliminar passageiro");
            System.out.println("5 - Voltar ao menu anterior");

            opcao = ler.nextInt();
            ler.nextLine();

            // chamar a funcao especifica a que o utilizador usar
            switch (opcao) {
                case 1:
                    MenuListaPassageirosListar();
                    break;
                case 2:
                    EditarPassageiroCompleto();
                    break;
                case 3:
                    AdicionarPassageiros();
                    break;
                case 4:
                    EliminarPassageiros();
                    break;
                case 5:
                    MenuPrincipal();
                    break;
                default:
                    System.out.println("Escolha desconhecida!");
            }
        } while (opcao != 5);
    }

    /**
     * Funcao que mostra ao utilizador o menu para listar os passageiros
     */
    public void MenuListaPassageirosListar() {

        int opcao;
        System.out.println("## MENU PASSAGEIROS - LISTAR ##");

        do {
            System.out.println("1 - Listar passageiros por voo");
            System.out.println("2 - Listar todos os passageiros");
            System.out.println("3 - Listar passageiros num intervalo de datas");
            System.out.println("4 - Voltar ao menu anterior");

            opcao = ler.nextInt();
            ler.nextLine();

            // chamar a funcao especifica a que o utilizador usar
            switch (opcao) {
                case 1:
                    ListarPassageirosPorVoo();
                    break;
                case 2:
                    ListarTodosOsPassageiros();
                    break;
                case 3:
                    ListarPassageirosPorData();
                    break;
                case 4:
                    ApresentarMenuPassageiro();
                    break;
                default:
                    System.out.println("Escolha desconhecida!");
                    break;
            }

        } while (opcao != 4);
    }

    /**
     * Funcao que mostra ao utilizador o menu da tripulacao
     */
    public void ApresentarMenuTripulacao() {

        int opcao;
        System.out.println("## MENU TRIPULANTES - LISTAR ##");

        do {
            System.out.println("1 - Listar pessoal cabine");
            System.out.println("2 - Editar pessoal cabine");
            System.out.println("3 - Adicionar pessoal cabine");
            System.out.println("4 - Eliminar pessoal cabine");
            System.out.println("5 - Voltar ao menu anterior");

            opcao = ler.nextInt();
            ler.nextLine();

            // chamar a funcao especifica a que o utilizador usar
            switch (opcao) {
                case 1:
                    ListarPessoalCabine();
                    break;
                case 2:
                    EditarCabine();
                    break;
                case 3:
                    AdicionarPessoalCabine();
                    break;
                case 4:
                    ElminarCabine();
                    break;
                case 5:
                    MenuPrincipal();
                    break;
                default:
                    System.out.println("Escolha desconhecida!");
                    break;
            }
        } while (opcao != 5);
    }

    /**
     * Funcao que mostra ao utilizador o menu de aeronaves
     */
    public void MenuAeronaves() {

        int opcao;
        System.out.println("## MENU AERONAVES ##");

        do {

            System.out.println("1 - Adicionar aeronave");
            System.out.println("2 - Listar aeronaves");
            System.out.println("3 - Editar aeronave");
            System.out.println("4 - Eliminar aeronave");
            System.out.println("5 - Voltar ao menu anterior");

            opcao = ler.nextInt();
            ler.nextLine();

            // chamar a funcao especifica a que o utilizador usar
            switch (opcao) {
                case 1:
                    AdicionarAaeronave();
                    break;
                case 2:
                    ListarAeronave();
                    break;
                case 3:
                    EditarAeronave();
                    break;
                case 4:
                    EliminarAeronave();
                    break;
                case 5:
                    MenuPrincipal();
                    break;
                default:
                    System.out.println("Escolha desconhecida!");
                    break;
            }
        } while (opcao != 5);
    }

    /**
     * Funcao que mostra ao utilizador o menu de aeroportos
     */
    public void MenuAeroportos() {

        int opcao;

        // escolher as opcoes do menu consoante ao que o utilizador deseja, e
        // repeticao
        // do menu
        System.out.println("## MENU AEROPORTOS ##");
        do {
            System.out.println("1 - Adicionar aeroporto");
            System.out.println("2 - Listar aeroportos");
            System.out.println("3 - Editar aeroporto");
            System.out.println("4 - Eliminar aeroporto");
            System.out.println("5 - Voltar ao menu anterior:");

            opcao = ler.nextInt();
            ler.nextLine();

            // chamar a funcao especifica a que o utilizador usar
            switch (opcao) {
                case 1:
                    AdicionarAaeroporto();
                    break;
                case 2:
                    ListarAaeroportos();
                    break;
                case 3:
                    EditarAeroporto();
                    break;
                case 4:
                    EliminarAeroporto();
                    break;
                case 5:
                    MenuPrincipal();
                    break;
                default:
                    System.out.println("Escolha desconhecida!");
                    break;
            }

        } while (opcao != 5);
    }

    /*
	 * 
	 * CONTROLO DE PASSAGEIROS
	 * 
     */
    /**
     * Funcao que obtem os passageiros pelo numero de identidade
     *
     * @param id obtem os passageiros pelo id
     * @return passageiros, retorna o passageiro
     */
    public Passageiros ObterPassageiroPorIdentidade(String id) {
        for (Passageiros passageiro : passageiros) {
            if (id.equals(passageiro.getId())) {
                return passageiro;
            }
        }
        return null;
    }

    /**
     * Funcao que conta o numero de passageiros
     *
     * @param numero conta os passageiros por voo
     * @return devolve a contagem dos passageiros
     */
    public int ContagemPassageirosVoo(String numero) {
        int contagem = 0;
        for (Passageiros passageiro : passageiros) {
            if (numero.equals(passageiro.getnVoo())) {
                contagem = contagem + 1;
            }
        }
        return contagem;
    }

    /**
     * Funcao que adiciona os passageiros ao voo
     */
    public void AdicionarPassageiros() {

        try {
            Passageiros passageiro = new Passageiros();

            System.out.print("Indique o n. do Voo:");
            passageiro.setnVoo(ler.nextLine());

            System.out.println("Identidade do passageiro:");
            passageiro.setId(ler.nextLine());

            System.out.println("Nome do passageiro:");
            passageiro.setNome(ler.nextLine());

            System.out.println("Nacionalidade:");
            passageiro.setNacionalidade(ler.nextLine());

            System.out.println("Morada:");
            passageiro.setMorada(ler.nextLine());

            System.out.println("Telefone:");
            passageiro.setTelefone(ler.nextLine());

            System.out.println("Data de nascimento:");
            passageiro.setDataDeNascimento(LerData().toString());
            ler.nextLine();

            System.out.println("E-mail:");
            passageiro.setEmail(ler.nextLine());

            System.out.println("Tipo do bilhete:");
            passageiro.setTipoBilhete(ler.nextLine());

            System.out.println("Lugar reservado:");
            passageiro.setLugarReservado(ler.nextLine());

            // adiciono ao arrayList
            this.passageiros.add(passageiro);

            System.out.println(" ");

            // mensagem ao utilizador
            System.out.println("Passageiro adicionado com sucesso!");
            System.out.println("\n-------------------------------------");

            // gravo os ficheiros
            GravarFicheirosPassageiros();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a inserir o novo passageiro!" + e.getMessage());
        }

    }

    /**
     * @author asaph Funcao que elimina os passageiros
     */
    public void EliminarPassageiros() {
        try {
            // pergunto ao utilizador o id do passageiro
            System.out.println("Insira o nr. da identidade do passageiro que deseja eliminar:");
            String idPassageiro = ler.nextLine();
            Passageiros encontrado = ObterPassageiroPorIdentidade(idPassageiro);

            if (encontrado != null) {
                passageiros.remove(encontrado);
                System.out.println(" ");
                System.out.println("Passageiro eliminado com sucesso!");
                System.out.println("\n-------------------------------------");
                GravarFicheirosPassageiros();
            } else {
                System.out.println(" ");
                System.out.println("Nao foi encontrado nenhum passageiro com o nr. da identidade indicado!");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a eliminar o passageiro!" + e.getMessage());
        }
    }

    /**
     * Funcao que edita os passageiros ja existentes
     */
    public void EditarPassageiroCompleto() {

        try {
            // identifico o passageiro
            System.out.println("Insira nr. de identidade do passageiro que deseja editar:");
            String idPassageiro = ler.nextLine();

            Passageiros passageiro = ObterPassageiroPorIdentidade(idPassageiro);
            if (passageiro != null) {

                System.out.println("Indique o nr. do Voo:");
                passageiro.setnVoo(ler.nextLine());

                System.out.println("Insira o novo numero de identidade do passageiro:");
                passageiro.setId(ler.nextLine());

                System.out.println("Insira o novo nome do passageiro:");
                passageiro.setNome(ler.nextLine());

                System.out.println("Insira a nova nacionalidade:");
                passageiro.setNacionalidade(ler.nextLine());

                System.out.println("Insira a nova morada:");
                passageiro.setMorada(ler.nextLine());

                System.out.println("Insira o novo telefone:");
                passageiro.setTelefone(ler.nextLine());

                System.out.println("Insira a nova data de nascimento:");
                passageiro.setDataDeNascimento(LerData().toString());

                System.out.println("Insira o novo e-mail:");
                passageiro.setEmail(ler.nextLine());

                System.out.println("Insira o novo tipo de bilhete:");
                passageiro.setTipoBilhete(ler.nextLine());

                System.out.println("Insira o novo lugar reservado:");
                passageiro.setLugarReservado(ler.nextLine());

                System.out.println(" ");

                System.out.println("Editado com sucesso!");
                System.out.println("\n-------------------------------------");

                GravarFicheirosPassageiros();

            } else {
                System.out.println("Passageiro Nao encontrado!");
                ApresentarMenuPassageiro();
            }
            ApresentarMenuVoo();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a alterar o passageiro!" + e.getMessage());
        }

    }

    /**
     * Funcao que lista os passageiros
     */
    public void ListarTodosOsPassageiros() {
        // Verifico se o array contem dados
        if (passageiros.isEmpty()) {
            System.out.println("Nao existem passageiros registados!");
            System.out.println(" ");
        } else {
            // Se contem, percorro o array e mostro ao utilizador
            for (Passageiros passageiro : passageiros) {
                System.out.println(passageiro);
            }

            ApresentarMenuPassageiro();
        }

    }

    /**
     * Funcao que lista os passageiros baseado numa data indicada pelo
     * utilizador
     */
    public void ListarPassageirosPorData() {

        System.out.println("Insira uma data de inicio (dd/MM/aaaa):");
        LocalDate dataInicioPesquisa = LerData();

        System.out.println("Insira uma data fim (dd/MM/aaaa):");
        LocalDate dataFimPesquisa = LerData();

        // procurar todos os voos dentro de determinada data
        int contador = 0;
        for (Voo voo : voos) {
            if ((voo.getDataDePartida().isAfter(dataInicioPesquisa)
                    || voo.getDataDePartida().isEqual(dataInicioPesquisa))
                    && (voo.getDataDeChegada().isBefore(dataFimPesquisa)
                    || voo.getDataDeChegada().isEqual(dataFimPesquisa))) {
                // para cada voo, vou procurar os passageiros
                for (Passageiros passageiro : passageiros) {
                    if (passageiro.getnVoo().equals(voo.getnVoo())) {
                        System.out.println(passageiro);
                        contador = contador + 1;
                    }
                }
            }
        }
        if (contador == 0) {
            System.out.println("\nNao foram encontrados passageiros nas datas indicadas.");
        } else {
            System.out.println("\nEncontrados " + contador + " passageiros.");
        }
    }

    /**
     * Funcao que lista os passageiros baseado num voo indicado pelo utilizador
     */
    public void ListarPassageirosPorVoo() {

        if (passageiros.isEmpty()) {
            System.out.println("Nao existem passageiros registados!");
            System.out.println(" ");
        } else {
            // Se contem, percorro o array e mostro ao utilizador
            System.out.println("Insira o nr. do voo:");
            String nVoo = ler.nextLine();

            Boolean encontradoPassageiros = false;
            for (Passageiros passageiros : passageiros) {
                if (passageiros.getnVoo().equals(nVoo)) {
                    System.out.println(passageiros);
                    encontradoPassageiros = true;
                }
            }
            if (encontradoPassageiros == false) {
                System.out.println("Nao existem passageiros para o voo indicado!");
            }
            ApresentarMenuPassageiro();
        }
    }

    /*
	 * 
	 * CONTROLO DE PESSOAL CABINE
	 * 
     */
    /**
     * Funcao que obtem os tripulantes pelo numero de identidade
     *
     * @param id obtem os tripulantes pelo numero de identidade
     * @return retorna o tripulante
     */
    public Tripulacao ObterTripulantePorIdentidade(String id) {
        for (Tripulacao tripulante : tripulantes) {
            if (id.equals(tripulante.getId())) {
                return tripulante;
            }
        }
        return null;
    }

    /**
     * Funcao que adiciona tripulantes
     */
    public void AdicionarPessoalCabine() {
        try {
            Tripulacao tripulacao = new Tripulacao();

            System.out.println("Identidade do funcionario:");
            tripulacao.setId(ler.nextLine());

            System.out.println("Nome do funcionario:");
            tripulacao.setNome(ler.nextLine());

            System.out.println("Nacionalidade:");
            tripulacao.setNacionalidade(ler.nextLine());

            System.out.println("Morada:");
            tripulacao.setMorada(ler.nextLine());

            System.out.println("Telefone:");
            tripulacao.setTelefone(ler.nextLine());

            System.out.println("Data de nascimento:");
            tripulacao.setDataDeNascimento(LerData().toString());

            System.out.println("Licenca:");
            tripulacao.setnLicenca(ler.nextLine());

            System.out.println("Data de validade:");
            tripulacao.setDataDeValidade(LerData().toString());

            System.out.println("Anotacoes:");
            tripulacao.setAnotacoes(ler.nextLine());

            System.out.println("Categoria:");
            tripulacao.setCategoria(ler.nextLine());

            // Adiciono ao array
            this.tripulantes.add(tripulacao);

            System.out.println(" ");

            // Mensagem ao utilizador
            System.out.println("Tripulante adicionado com sucesso!");
            System.out.println("\n-------------------------------------");

            // Gravo para ficheiros
            GravarFicheirosTripulantes();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a adicionar tripulante!" + e.getMessage());
        }

        // Volto ao menu
        ApresentarMenuTripulacao();

    }

    /**
     * Funcao que lista os tripulantes de cabine
     */
    public void ListarPessoalCabine() {

        // Verifico se contem dados no array
        if (tripulantes.isEmpty()) {
            System.out.println("Nao existem tripulantes registados!");
            System.out.println(" ");
        } else {

            // Percorro o array e apresento a informação de cada tripulante
            for (Tripulacao tripulante : tripulantes) {
                System.out.println(tripulante);
            }

            // Volto ao menu anterior
            ApresentarMenuTripulacao();
        }
    }

    /**
     * Funcao que elimina os tripulantes
     */
    public void ElminarCabine() {
        try {
            System.out.println("Insira o nr. da identidade do tripulante que deseja eliminar:");
            String idTripulante = ler.nextLine();

            Tripulacao encontrado = ObterTripulantePorIdentidade(idTripulante);

            if (encontrado != null) {
                tripulantes.remove(encontrado);
                System.out.println(" ");
                System.out.println("Tripulante eliminado com sucesso!");
                System.out.println("\n-------------------------------------");
                GravarFicheirosTripulantes();
            } else {
                System.out.println(" ");
                System.out.println("Nao foi encontrado nenhum tripulante com o nr. da identidade indicado!");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a eliminar tripulante!" + e.getMessage());
        }
    }

    /**
     * Funcao que edita os tripulantes
     */
    public void EditarCabine() {
        try {
            String idTripulante;

            // Pergunto ao utilizador a identidade do tripulante
            System.out.println("Insira o nr. de identidade do tripulante que deseja editar:");
            idTripulante = ler.nextLine();

            Tripulacao tripulante = ObterTripulantePorIdentidade(idTripulante);
            if (tripulante != null) {

                System.out.println("Indique o nr. do Voo:");
                tripulante.setnVoo(ler.nextLine());

                System.out.println("Insira o novo nr. de identidade do tripulante:");
                tripulante.setId(ler.nextLine());

                System.out.println("Insira o novo nome do tripulante:");
                tripulante.setNome(ler.nextLine());

                System.out.println("Insira a nova nacionalidade:");
                tripulante.setNacionalidade(ler.nextLine());

                System.out.println("Insira a nova morada:");
                tripulante.setMorada(ler.nextLine());

                System.out.println("Insira o novo telefone:");
                tripulante.setTelefone(ler.nextLine());

                System.out.println("Insira a nova data de nascimento:");
                tripulante.setDataDeNascimento(ler.nextLine());

                System.out.println("Insira a nova licenca:");
                tripulante.setnLicenca(ler.nextLine());

                System.out.println("Insira a nova data de validade:");
                tripulante.setDataDeValidade(ler.nextLine());

                System.out.println("Insira as novas anotacoes:");
                tripulante.setAnotacoes(ler.nextLine());

                System.out.println("Insira a nova categoria:");
                tripulante.setCategoria(ler.nextLine());

                System.out.println(" ");

                // Mensagem ao utilizador se conseguir
                System.out.println("Editado com sucesso!");
                System.out.println("\n-------------------------------------");

                GravarFicheirosTripulantes();

            } else {
                // Mensagem ao utilizador se nao encontrar o tripulante
                System.out.println("Tripulante Nao encontrado!");
                ApresentarMenuPassageiro();
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a editar tripulante!" + e.getMessage());
        }
    }

    /*
	 * 
	 * CONTROLO DE VOOS
	 * 
     */
    /**
     * Funcao que obtem os voos baseado no numero do voo
     *
     * @param numero obtem voos baseados no numero
     * @return devolve os voos baseado no numero do voo
     */
    public Voo ObterVooPorNumero(String numero) {
        for (Voo voo : voos) {
            if (numero.equals(voo.getnVoo())) {
                return voo;
            }
        }
        return null;
    }

    /**
     * Funcao que elimina os voos da companhia
     */
    public void EliminarVoo() {
        try {
            System.out.println("Insira o nr. do voo que deseja eliminar:");
            String numVoo = ler.nextLine();

            Voo encontrado = ObterVooPorNumero(numVoo);

            // Removo do array
            if (encontrado != null) {
                voos.remove(encontrado);

                System.out.println(" ");
                System.out.println("Voo eliminado com sucesso!");
                System.out.println("\n-------------------------------------");

                GravarFicheirosVoos();
            } else {
                System.out.println(" ");
                System.out.println("Nao foi encontrado nenhum voo com o nr. indicado!");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a elminar voo!" + e.getMessage());
        }
    }

    /**
     * Funcao que adiciona os voos
     */
    public void AdicionarVoo() {
        try {
            Voo voo = new Voo();

            System.out.println("Insira o numero do voo: ");
            voo.setnVoo(ler.nextLine());

            // verifico se ja existe um voo com o nr. indicado
            if (ObterVooPorNumero(voo.getnVoo()) != null) {
                System.out.println("Ja existe um voo com o nr. inserido.");
            } else {
                System.out.println("Insira o nome do aviao: ");
                voo.setAviao(ler.nextLine());

                System.out.println("Insira o aeroporto de origem: ");
                voo.setAeroOrigem(ler.nextLine());

                System.out.println("Insira o aeroporto de destino: ");
                voo.setAeroDestino(ler.nextLine());

                System.out.println("Insira a data de partida: ");
                voo.setDataDePartida(LerData());

                System.out.println("Insira a data de chegada: ");
                voo.setDataDeChegada(LerData());

                System.out.println("Insira a hora de partida: ");
                voo.setHoraDePartida(ler.nextLine());

                System.out.println("Insira a hora de chegada: ");
                voo.setHoraDeChegada(ler.nextLine());

                // adiciono no array
                this.voos.add(voo);

                System.out.println(" ");
                System.out.println("Voo adicionado com sucesso!");
                System.out.println("\n-------------------------------------");

                GravarFicheirosVoos();
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a adicionar voo!" + e.getMessage());
        }
    }

    /**
     * Funcao que edita os voos
     */
    public void EditarVooCompleto() {
        try {
            // Pergunto ao utilizador os numero do voo
            System.out.println("Insira o nr. do voo que deseja editar:");
            String numeroVoo = ler.nextLine();

            Voo voo = ObterVooPorNumero(numeroVoo);
            if (voo != null) {
                System.out.println("Insira o novo nr. do voo:");
                voo.setnVoo(ler.nextLine());

                System.out.println("Insira o novo nr. do aviao:");
                voo.setAviao(ler.nextLine());

                System.out.println("Insira o novo aeroporto de origem:");
                voo.setAeroOrigem(ler.nextLine());

                System.out.println("Insira o novo aeroporto de destino:");
                voo.setAeroDestino(ler.nextLine());

                System.out.println("Insira a nova data de partida:");
                voo.setDataDePartida(LerData());

                System.out.println("Insira a nova data de chegada:");
                voo.setDataDeChegada(LerData());

                System.out.println("Insira a nova hora de partida:");
                voo.setHoraDePartida(ler.nextLine());

                System.out.println("Insira a nova hora de chegada:");
                voo.setHoraDeChegada(ler.nextLine());

                System.out.println(" ");
                System.out.println("Voo editado com sucesso!");
                System.out.println("\n-------------------------------------");

                // Gravo para ficheiros
                GravarFicheirosVoos();

                ApresentarMenuVoo();

            } else {
                System.out.println(" ");
                System.out.println("Voo nao encontrado!");
                ApresentarMenuVoo();
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a editar voo!" + e.getMessage());
        }
    }

    /**
     * Funcao que lista todos os voos
     */
    public void ListarVoos() {

        // Verifico se existem dados registados
        if (voos.isEmpty()) {
            System.out.println("Nao existem voos registados!");
            System.out.println(" ");
        } else {
            // Percorro o array e mostro os dados
            for (Voo voo : voos) {
                System.out.println(voo);
            }
            ApresentarMenuVoo();
        }

    }

    /**
     * Funcao que lista um voo indicado pelo utilizador
     */
    public void ListarVoosPorNumero() {
        System.out.println("Insira o nr. do voo:");
        String numeroVoo = ler.nextLine();

        Voo encontrado = ObterVooPorNumero(numeroVoo);
        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("Nao existem voo registado com o nr.!");
        }
        MenuVooListar();
    }

    /**
     * Funcao que lista o voo com mais passageiros
     */
    public void ListarVoosComMaisPassageiros() {

    }

    /**
     * Funcao que os voos baseados num intervalo de datas indicados pelo
     * utilizador
     */
    public void FiltrarVoosPorData() {

        System.out.println("Insira uma data de inicio (dd/MM/aaaa):");
        LocalDate dataInicioPesquisa = LerData();

        System.out.println("Insira uma data fim (dd/MM/aaaa):");
        LocalDate dataFimPesquisa = LerData();

        Boolean encontradoVoos = false;
        int contagemPassageiros = 0;

        for (Voo voo : voos) {
            if ((voo.getDataDePartida().isAfter(dataInicioPesquisa)
                    || voo.getDataDePartida().isEqual(dataInicioPesquisa))
                    && (voo.getDataDeChegada().isBefore(dataFimPesquisa)
                    || voo.getDataDeChegada().isEqual(dataFimPesquisa))) {
                System.out.println(voo);
                encontradoVoos = true;
                contagemPassageiros = contagemPassageiros + ContagemPassageirosVoo(voo.getnVoo());
            }
        }
        if (encontradoVoos == false) {
            System.out.println("Nao existem voo registado com as datas indicadas!");
        } else {
            System.out.println("Estatisticas:");
            System.out.println("Total passageiros : " + contagemPassageiros);
            System.out.println("--------------------------------------------------------------------");
            System.out.println("");
        }
        MenuVooListar();
    }

    /**
     * Funcao que lista os voos baseados numa rota indicada pelo utilizador
     */
    public void FilrarVoosPorRota() {
        System.out.println("Insira o aeroporto de origem:");
        String aeroportoOrigem = ler.nextLine();

        System.out.println("Insira o aeroporto de destino:");
        String aeroportoDestino = ler.nextLine();

        Boolean encontradoVoos = false;
        int contagemPassageiros = 0;
        int contagemVoos = 0;

        for (Voo voo : voos) {
            if (voo.getAeroOrigem().equalsIgnoreCase(aeroportoOrigem)
                    && (voo.getAeroDestino().equalsIgnoreCase(aeroportoDestino))) {
                System.out.println(voo);
                encontradoVoos = true;
                contagemPassageiros = contagemPassageiros + ContagemPassageirosVoo(voo.getnVoo());
                contagemVoos = contagemVoos + 1;
            }
        }
        if (encontradoVoos == false) {
            System.out.println("Nao existem voo registado com as datas indicadas!");
        } else {
            System.out.println("Estatisticas:");
            System.out.println("Total passageiros : " + contagemPassageiros);
            System.out.println("Media passageiros rota: " + contagemPassageiros / contagemVoos);
            System.out.println("--------------------------------------------------------------------");
        }
        MenuVooListar();
    }

    /*
	 * 
	 * CONTROLO DE AERONAVES
	 * 
     */
    /**
     * Funcao que obtem as aeronaves pelo numero
     *
     * @param numero obtem as aeronaves por numero
     * @return devolve a aeronave
     */
    public Aeronave ObterAeronavePorNumero(String numero) {
        for (Aeronave aeronave : aeronaves) {
            if (numero.equals(aeronave.getnRegistro())) {
                return aeronave;
            }
        }
        return null;
    }

    /**
     * Funcao que adiciona a aeronave no sistema
     */
    public void AdicionarAaeronave() {
        try {
            Aeronave aeronave = new Aeronave();

            // Prencho os dados
            System.out.println("Insira o nr. de registo:");
            aeronave.setnRegistro(ler.nextLine());

            System.out.println("Insira a marca/modelo:");
            aeronave.setMarcaEmodelo(ler.nextLine());

            System.out.println("Insira o nr. de lugares na classe executiva:");
            aeronave.setNlugaresExecutiva(ler.nextLine());

            System.out.println("Insira o nr. de lugares na classe turistica:");
            aeronave.setNlugaresTuristica(ler.nextLine());

            // adiciono ao array
            this.aeronaves.add(aeronave);

            System.out.println(" ");
            System.out.println("Aeronave adicionada com sucesso!");
            System.out.println("\n-------------------------------------");

            // Gravo para ficheiros
            GravarFicheirosAeronave();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a adicionar aeronave!" + e.getMessage());
        }
    }

    /**
     * Funcao que lista as aeronaves registadas
     */
    public void ListarAeronave() {
        // Verifico se contem dados
        if (aeronaves.isEmpty()) {
            System.out.println("Nao existem aeronaves registadas!");
            System.out.println(" ");
        } else {

            // Percorro o array e mostro os dados
            for (Aeronave aeronave : aeronaves) {
                System.out.println(aeronave);
            }

            MenuAeronaves();
        }
    }

    /**
     * Funcao que elimina a aeronave
     */
    public void EliminarAeronave() {
        try {
            // Pergunto ao utilizador os dados
            System.out.println("Insira o nr. de registo da aeronave que deseja eliminar:");
            String numAeronave = ler.nextLine();

            Aeronave encontrado = ObterAeronavePorNumero(numAeronave);

            // Removo do array
            if (encontrado != null) {
                aeronaves.remove(encontrado);

                System.out.println(" ");
                System.out.println("Aeronave eliminada com sucesso!");
                System.out.println("\n-------------------------------------");

                GravarFicheirosAeronave();
            } else {
                System.out.println(" ");
                System.out.println("Nao foi encontrado nenhuma aeronave com o nr. indicado!");
            }

            MenuAeronaves();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a eliminar aeronave!" + e.getMessage());
        }
    }

    /**
     * Funcao que edita as aeronaves registadas
     */
    public void EditarAeronave() {
        try {
            // Pergunto ao utilizador a aeronave que ele quer editar
            System.out.println("Insira o nr. de registo da aeronave que deseja editar:");
            String numeroAeronave = ler.nextLine();

            Aeronave aeronave = ObterAeronavePorNumero(numeroAeronave);
            if (aeronave != null) {
                System.out.println("Insira o novo numero de registo:");
                aeronave.setnRegistro(ler.nextLine());

                System.out.println("Insira a nova marca/modelo:");
                aeronave.setMarcaEmodelo(ler.nextLine());

                System.out.println("Insira o novo numero de lugares da classe executiva:");
                aeronave.setNlugaresExecutiva(ler.nextLine());

                System.out.println("Insira o novo numero de lugares da classe turistica:");
                aeronave.setNlugaresTuristica(ler.nextLine());

                System.out.println(" ");
                System.out.println("Editado com sucesso!");
                System.out.println("\n-------------------------------------");

                GravarFicheirosAeronave();

                MenuAeronaves();
            } else {
                System.out.println(" ");
                System.out.println("Aeronave Nao encontrada!");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a editar aeronave!" + e.getMessage());
        }
    }

    /*
	 * 
	 * CONTROLO DE AEROPORTOS
	 * 
     */
    /**
     * Funcao que obtem os aeroportos por sigla
     *
     * @param sigla obtem os aeroportos pela sigla
     * @return devolve a sigla
     */
    public Aeroporto ObterAeroportoPorSigla(String sigla) {
        for (Aeroporto aeroporto : aeroportos) {
            if (sigla.equals(aeroporto.getSigla())) {
                return aeroporto;
            }
        }
        return null;
    }

    /**
     * Funcao que adiciona aeroportos ao sistema
     */
    public void AdicionarAaeroporto() {
        try {
            Aeroporto aeroportos = new Aeroporto();

            // Adiciono os dados
            System.out.println("Insira a sigla do aeroporto:");
            aeroportos.setSigla(ler.nextLine());

            System.out.println("Insira o pais:");
            aeroportos.setPais(ler.nextLine());

            System.out.println("Insira a cidade mais proxima:");
            aeroportos.setCidadeProx(ler.nextLine());

            // Adiciono ao array
            this.aeroportos.add(aeroportos);

            System.out.println(" ");
            System.out.println("Aeroporto adicionado com sucesso!");
            System.out.println("\n-------------------------------------");

            GravarFicheirosAeroportos();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a adicionar aeroporto!" + e.getMessage());
        }
    }

    /**
     * Funcao que lista os aeroportos do sistema
     */
    public void ListarAaeroportos() {

        // Verifico se existem dados registados
        if (aeroportos.isEmpty()) {
            System.out.println("Nao existem aeroportos registados!");
            System.out.println(" ");
        } else {

            // Percorro o array e mostro o conteudo
            for (Aeroporto aeroporto : aeroportos) {
                System.out.println(aeroporto);
            }

            MenuAeroportos();
        }
    }

    /**
     * Funcao que elimina os aeroportos do sistema
     */
    public void EliminarAeroporto() {
        try {
            // Pergunto ao utilizador a sigla do aeroporto
            System.out.println("Insira a sigla do aeroporto que deseja eliminar:");
            String sigla = ler.nextLine();

            Aeroporto encontrado = ObterAeroportoPorSigla(sigla);

            // Removo do array
            if (encontrado != null) {
                aeroportos.remove(encontrado);

                System.out.println(" ");
                // Mensagem ao utilizador
                System.out.println("Aeroporto eliminado com sucesso!");
                System.out.println("\n-------------------------------------");
            } else {
                System.out.println(" ");
                System.out.println("Nao foi encontrado nenhum aeroporto com a sigla indicada!");
            }

            MenuAeroportos();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a eliminar aeroporto!" + e.getMessage());
        }
    }

    /**
     * Funcao que edita os aeroportos do sistema
     */
    public void EditarAeroporto() {
        try {
            System.out.println("Insira a sigla do aeroporto que deseja editar:");
            String sigla = ler.nextLine();

            Aeroporto aeroporto = ObterAeroportoPorSigla(sigla);
            if (aeroporto != null) {
                // Se encontrado, edito os dados
                System.out.println("Insira a nova sigla:");
                aeroporto.setSigla(ler.nextLine());

                System.out.println("Insira o novo pais:");
                aeroporto.setPais(ler.nextLine());

                System.out.println("Insira a nova cidade mais proxima:");
                aeroporto.setCidadeProx(ler.nextLine());

                System.out.println(" ");
                System.out.println("Editado com sucesso!");
                System.out.println("\n-------------------------------------");

                GravarFicheirosAeroportos();

                MenuAeroportos();
            } else {
                // Se nao, mensagem ao utilizador
                System.out.println("Aeroporto Nao encontrado!");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro a editar aeroporto!" + e.getMessage());
        }
    }

    /*
	 * 
	 * CONTROLO DE FICHEIROS
	 * 
     */
    private String ObterPastaFicheirosCompanhia() {

        // verificar se a pasta existe, se nao existir cria
        String diretorioDados = this.LocalizacaoDados + "\\" + this.companhia;
        File theDir = new File(diretorioDados);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        return diretorioDados;
    }

    private void LerFicheirosVoos() {
        try {
            String conteudo = this.LerFicheiro("voos");
            if (conteudo != "") {
                String[] linhas = conteudo.split("\n");
                for (String linha : linhas) {
                    String[] partes = linha.split("\\|");

                    String nVoo = partes[0];
                    String Aviao = partes[1];
                    String AeroOrigem = partes[2];
                    String AeroDestino = partes[3];
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate DataDePartida = LocalDate.parse(partes[4], formatter);
                    LocalDate DataDeChegada = LocalDate.parse(partes[5], formatter);
                    String HoraDePartida = partes[6];
                    String HoraDeChegada = partes[7];

                    Voo voo = new Voo(nVoo, Aviao, AeroOrigem, AeroDestino, DataDePartida, DataDeChegada, HoraDePartida,
                            HoraDeChegada);
                    voos.add(voo);
                }
            }
        } catch (Exception Ex) {
            System.out.println("Ocorreu um erro a ler voos!" + Ex.getMessage());
        }
    }

    private void GravarFicheirosVoos() {
        try {
            String conteudo = "";
            if (voos.isEmpty() == false) {
                conteudo = "";
                for (Voo voo : voos) {
                    conteudo += voo.getnVoo() + "|";
                    conteudo += voo.getAviao() + "|";
                    conteudo += voo.getAeroOrigem() + "|";
                    conteudo += voo.getAeroDestino() + "|";
                    conteudo += voo.getDataDePartida() + "|";
                    conteudo += voo.getDataDeChegada() + "|";
                    conteudo += voo.getHoraDePartida() + "|";
                    conteudo += voo.getHoraDeChegada() + "|\n";
                }
            }
            this.GravarFicheiro("voos", conteudo);
        } catch (Exception Ex) {
            System.out.println("Ocorreu um erro a gravar voos!" + Ex.getMessage());
        }
    }

    private void LerFicheirosPassageiros() {
        try {
            String conteudo = this.LerFicheiro("passageiros");
            if (conteudo != "") {
                String[] linhas = conteudo.split("\n");
                for (String linha : linhas) {
                    String[] partes = linha.split("\\|");

                    String id = partes[0];
                    String nVoo = partes[1];
                    String nome = partes[2];
                    String nacionalidade = partes[3];
                    String morada = partes[4];
                    String telefone = partes[5];
                    String dataDeNascimento = partes[6];
                    String email = partes[7];
                    String tipoBilhete = partes[8];
                    String lugarReservado = partes[9];

                    Passageiros passageiros = new Passageiros(id, nVoo, nome, nacionalidade, morada, telefone,
                            dataDeNascimento, email, tipoBilhete, lugarReservado);

                    this.passageiros.add(passageiros);
                }
            }
        } catch (Exception Ex) {
            System.out.println("Ocorreu um erro a ler passageiros!" + Ex.getMessage());
        }
    }

    private void GravarFicheirosPassageiros() {
        try {
            String conteudo = "";
            if (passageiros.isEmpty() == false) {
                conteudo = "";
                for (Passageiros passageiro : passageiros) {
                    conteudo += passageiro.getId() + "|";
                    conteudo += passageiro.getnVoo() + "|";
                    conteudo += passageiro.getNome() + "|";
                    conteudo += passageiro.getNacionalidade() + "|";
                    conteudo += passageiro.getMorada() + "|";
                    conteudo += passageiro.getTelefone() + "|";
                    conteudo += passageiro.getDataDeNascimento() + "|";
                    conteudo += passageiro.getEmail() + "|";
                    conteudo += passageiro.getTipoBilhete() + "|";
                    conteudo += passageiro.getLugarReservado() + "|\n";
                }
            }
            this.GravarFicheiro("passageiros", conteudo);
        } catch (Exception Ex) {
            System.out.println("Ocorreu um erro a gravar passageiros!" + Ex.getMessage());
        }
    }

    private void LerFicheirosAeroportos() {
        try {
            String conteudo = this.LerFicheiro("aeroportos");
            if (conteudo != "") {
                String[] linhas = conteudo.split("\n");
                for (String linha : linhas) {
                    String[] partes = linha.split("\\|");

                    String sigla = partes[0];
                    String pais = partes[1];
                    String cidadeProx = partes[2];

                    Aeroporto aeroporto = new Aeroporto(sigla, pais, cidadeProx);
                    aeroportos.add(aeroporto);
                }
            }
        } catch (Exception Ex) {
            System.out.println("Ocorreu um erro a ler aeroportos!" + Ex.getMessage());
        }
    }

    private void GravarFicheirosAeroportos() {
        try {
            String conteudo = "";
            if (aeroportos.isEmpty() == false) {
                conteudo = "";
                for (Aeroporto aeroporto : aeroportos) {
                    conteudo += aeroporto.getSigla() + "|";
                    conteudo += aeroporto.getPais() + "|";
                    conteudo += aeroporto.getCidadeProx() + "\n";
                }
            }
            this.GravarFicheiro("aeroportos", conteudo);
        } catch (Exception Ex) {
            System.out.println("Ocorreu um erro a gravar aeroportos!" + Ex.getMessage());
        }
    }

    private void LerFicheirosAeronaves() {
        try {
            String conteudo = this.LerFicheiro("aeronaves");
            if (conteudo != "") {
                String[] linhas = conteudo.split("\n");
                for (String linha : linhas) {
                    String[] partes = linha.split("\\|");

                    String nRegistro = partes[0];
                    String marcaEmodelo = partes[1];
                    String nLugaresTuristica = partes[2];
                    String nLugaresExecutiva = partes[3];

                    Aeronave aeronave = new Aeronave(nRegistro, marcaEmodelo, nLugaresTuristica, nLugaresExecutiva);
                    aeronaves.add(aeronave);
                }
            }
        } catch (Exception Ex) {
            System.out.println("Ocorreu um erro a ler aeronaves!" + Ex.getMessage());
        }
    }

    private void GravarFicheirosAeronave() {
        try {
            String conteudo = "";
            if (aeronaves.isEmpty() == false) {
                conteudo = "";
                for (Aeronave aeronave : aeronaves) {
                    conteudo += aeronave.getnRegistro() + "|";
                    conteudo += aeronave.getMarcaEmodelo() + "|";
                    conteudo += aeronave.getNlugaresTuristica() + "|";
                    conteudo += aeronave.getNlugaresExecutiva() + "\n";
                }
            }
            this.GravarFicheiro("aeronaves", conteudo);
        } catch (Exception Ex) {
            System.out.println("Ocorreu um erro a gravar aeronaves!" + Ex.getMessage());
        }
    }

    private void LerFicheirosTripulantes() {
        try {
            String conteudo = this.LerFicheiro("tripulantes");
            if (conteudo != "") {
                String[] linhas = conteudo.split("\n");
                for (String linha : linhas) {
                    String[] partes = linha.split("\\|");

                    String id = partes[0];
                    String nVoo = partes[1];
                    String nome = partes[2];
                    String nacionalidade = partes[3];
                    String morada = partes[4];
                    String telefone = partes[5];
                    String dataDeNascimento = partes[6];
                    String nLicenca = partes[7];
                    String dataDeValidade = partes[8];
                    String anotacoes = partes[9];
                    String categoria = partes[10];

                    Tripulacao tripulante = new Tripulacao(id, nVoo, nome, nacionalidade, morada, telefone,
                            dataDeNascimento, nLicenca, dataDeValidade, anotacoes, categoria);
                    this.tripulantes.add(tripulante);
                }
            }
        } catch (Exception Ex) {
            System.out.println("Ocorreu um erro a ler tripulantes!" + Ex.getMessage());
        }
    }

    private void GravarFicheirosTripulantes() {
        try {
            String conteudo = "";
            if (tripulantes.isEmpty() == false) {
                conteudo = "";
                for (Tripulacao tripulante : tripulantes) {
                    conteudo += tripulante.getId() + "|";
                    conteudo += tripulante.getnVoo() + "|";
                    conteudo += tripulante.getNome() + "|";
                    conteudo += tripulante.getNacionalidade() + "|";
                    conteudo += tripulante.getMorada() + "|";
                    conteudo += tripulante.getTelefone() + "|";
                    conteudo += tripulante.getDataDeNascimento() + "|";
                    conteudo += tripulante.getnLicenca() + "|";
                    conteudo += tripulante.getDataDeValidade() + "|";
                    conteudo += tripulante.getAnotacoes() + "|";
                    conteudo += tripulante.getCategoria() + "|\n";
                }
            }
            this.GravarFicheiro("tripulantes", conteudo);
        } catch (Exception Ex) {
            System.out.println("Ocorreu um erro a gravar tripulantes!" + Ex.getMessage());
        }
    }

    private String LerFicheiro(String nomeFicheiro) {
        String conteudo = "";
        try {
            String enderecoFicheiro = ObterPastaFicheirosCompanhia() + "\\" + nomeFicheiro + ".txt";
            File f = new File(enderecoFicheiro);
            if (f.exists()) {
                FileReader fr = new FileReader(enderecoFicheiro);
                BufferedReader ler = new BufferedReader(fr);
                while (ler.ready()) {
                    conteudo += ler.readLine() + "\n";
                }
                ler.close();
            }

        } catch (IOException Ex) {
            System.out.println("Ocorreu um erro a ler o ficheiro!" + Ex.getMessage());
        }
        return conteudo;
    }

    private void GravarFicheiro(String nomeFicheiro, String conteudo) {
        try {
            FileWriter fw = new FileWriter(ObterPastaFicheirosCompanhia() + "\\" + nomeFicheiro + ".txt");
            BufferedWriter caneta = new BufferedWriter(fw);
            caneta.write(conteudo);
            caneta.close();
        } catch (IOException Ex) {
            {
                System.out.println("Ocorreu um erro a gravar! " + Ex.getMessage());
            }
        }
    }

    // Funcao para ler e converter data
    private LocalDate LerData() {
        try {
            LocalDate data;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            data = LocalDate.parse(ler.nextLine(), formatter);
            return data;
        } catch (Exception ex) {
            System.out.println("Data invalida, insira uma data com o formato (dd/MM/aaaa):");
            return LerData();
        }
    }

}

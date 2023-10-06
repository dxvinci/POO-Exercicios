import java.time.LocalDate;
import java.util.Scanner;

public class AppLista3 {

    static Scanner sc;

    /**
     * "Limpa" a tela (códigos de terminal VT-100)
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Encapsula uma leitura de teclado, com mensagem personalizada. A mensagem sempre é completada com ":". Retorna uma string
     * que pode ser posteriormente convertida.
     * @param mensagem A mensagem a ser exibida, sem pontuação final.
     * @return String lida do usuário.
     */
    public static String leitura(String mensagem){
        System.out.print(mensagem+": ");
        return sc.nextLine();
    }

    /**
     * Pausa para leitura de mensagens em console.
     */
    static void pausa() {
        System.out.println("Enter para continuar.");
        sc.nextLine();
    }

    /**
     * Exibe o menu principal e retorna a opção escolhida.
     * @return Opção escolhida.
     */
    public static int menuPrincipal() {
        int opcao;
        System.out.println("1 - Cadastro");
        System.out.println("2 - Registrar visita");
        System.out.println("3 - Registrar saída");
        System.out.println("4 - Gerar convite");
        System.out.println("5 - Relatório de visitas por Data");
        System.out.println("6 - Relatório de visitas por Frequentador");
        System.out.println("0 - Sair");
        System.out.println();
        opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    /**
     * Exibe o menu de cadastro e retorna a opção escolhida.
     */
    public static void menuCadastro(Clube clube) {
        limparTela();
        int opcao;
        System.out.println("1 - Sócio");
        System.out.println("2 - Convidado");
        System.out.println("0 - Sair");
        System.out.println();
        opcao = sc.nextInt();

        sc.nextLine();
        opcoesCadastrarFrequentador(opcao, clube);
    }

    public static void opcoesCadastrarFrequentador(int opcao, Clube clube) {
        switch (opcao) {
            case 1 -> {
                limparTela();
                Socio socio = cadastroSocio();
                clube.addFrequentador(socio);
            }
            case 2 -> {
                limparTela();
                Convidado convidado = cadastroConvidado();
                clube.addFrequentador(convidado);
            }
        }
    }

    /**
     * Encapsula a ação de instanciar um objeto sócio. Retorna um objeto Socio.
     * @return Objeto Socio.
     */
    public static Socio cadastroSocio() {
        limparTela();
        String nome = leitura("Informe o nome do sócio");
        return new Socio(nome);
    }

    /**
     * Encapsula a ação de instanciar um objeto convidado. Retorna um objeto Convidado.
     * @return Objeto Convidado.
     */
    public static Convidado cadastroConvidado() {
        limparTela();
        String nome = leitura("Informe o nome do convidado");
        return new Convidado(nome);
    }

    /**
     * Exibe o menu de geração de convites e retorna a opção escolhida.
     * @return Opção escolhida.
     */
    public static int menuGerarConvite() {
        limparTela();
        int opcao;
        System.out.println("Convidado já possui cadastro?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.println("0 - Sair");
        opcao = sc.nextInt();
        sc.nextLine();

        return opcao;
    }

    /**
     * Encapsula a ação de gerar um convite baseado na opção escolhida. Caso o convidado não esteja cadastrado,
     * cadastra o Convidado e então gera o convite.
     * @param opcao Opção escolhida.
     * @param clube Objeto Clube.
     */
    public static void opcoesGerarConvite(int opcao, Clube clube) {
        switch (opcao) {
            case 1 -> gerarConvite(clube);
            case 2 -> {
                limparTela();
                Convidado convidado = cadastroConvidado();
                clube.addFrequentador(convidado);
                gerarConvite(clube);
            }
        }
    }

    /**
     * Encapsula a ação de gerar um convite.
     * @param clube Objeto Clube.
     */
    public static void gerarConvite(Clube clube) {
        limparTela();
        String idSocio = leitura("Informe o ID do sócio");
        String idConvidado = leitura("Informe o ID do convidado");
        String data = leitura("Informe a data do convite (dd/mm/aaaa)");
        clube.gerarConvite(idSocio, idConvidado, data);
        pausa();
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Clube clube = new Clube();

        int opcao = -1;
        while (opcao != 0) {
            limparTela();
            opcao = menuPrincipal();
            switch (opcao) {
                case 1 -> menuCadastro(clube);
                case 2 -> {
                    String id = leitura("Informe o ID do frequentador");
                    clube.registrarVisita(id);
                    pausa();
                }
                case 3 -> {
                    String id = leitura("Informe o ID do frequentador");
                    clube.registrarSaida(id);
                    pausa();
                }
                case 4 -> {
                    opcao = menuGerarConvite();
                    opcoesGerarConvite(opcao, clube);
                }
                case 5 -> {
                    String data = leitura("Informe a data (dd/mm/aaaa)");
                    System.out.println(clube.relatorioVisitasData(LocalDate.parse(data, Clube.DATE_FORMAT)));
                    pausa();
                }
                case 6 -> {
                    String id = leitura("Informe o ID do Frequentador");
                    System.out.println(clube.relatorioVisitasFreq(id));
                    pausa();
                }
                default -> {
                    System.out.println("Opção inválida");
                    pausa();
                }
                case 0 ->
                    System.out.println("Saindo...");
            }
        }
        System.out.println("VLW FLW OBG T+.");
        sc.close();

    }

}

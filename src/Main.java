import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<PessoaJuridica> ListaPj = new ArrayList<>();
        PessoaJuridica metodosPj = new PessoaJuridica();

        ArrayList<PessoaFisica> ListaPf = new ArrayList<>();
        PessoaFisica metodosPf = new PessoaFisica();

        System.out.println("Bem vindo(a) ao sistema de cadastro de pessoa Fisica e Pessoa Juridica");

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("Escolha um opcao: 1 - Pessoa Fisica / 2 - Pessoa Juridica / 0 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int opcaoPF;
                    do {

                        System.out.println("Escolha uma opcao: 1 - Cadastrar Pessoa Fisica / 2 - Listar Pessoa Fisica / 0 - Voltar ao menu anterior ");
                        opcaoPF = scanner.nextInt();

                        switch (opcaoPF) {
                            case 1:
                                PessoaFisica novapf = new PessoaFisica();
                                Endereco novoEndPF = new Endereco();

                                System.out.println("Digite o nome da pessoa fisica: ");
                                novapf.nome = scanner.next();

                                System.out.println("Digite o CPF : ");
                                novapf.cpf = scanner.next();

                                System.out.println("Digite o rendimento mensal (Digite somente numero) : ");
                                novapf.rendimento = scanner.nextInt();

                                System.out.println("Digite a data de Nascimento (dd/MM/aaa): ");
                                LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyy"));
                                Period period = Period.between(date, LocalDate.now());

                                novapf.dataNascimento = date;

                                if (period.getYears() >= 18) {
                                    System.out.println("A pessoa tem mais de 18 anos, agora pode ser preso");
                                } else {
                                    System.out.println("Que isso meno. Vai ve Cartoon q e melhor...");
                                    break;
                                }

                                System.out.println("Digite o logradouro: ");
                                novoEndPF.logradouro = scanner.next();

                                System.out.println("Digite o numero: ");
                                novoEndPF.numero = scanner.next();

                                System.out.println("Este endereco e comercial? S/N: ");
                                String endCom;
                                endCom = scanner.next();

                                if (endCom.equalsIgnoreCase("S")) {
                                    novoEndPF.enderecoComercial = true;
                                } else {
                                    novoEndPF.enderecoComercial = false;
                                }

                                novapf.endereco = novoEndPF;

                                ListaPf.add(novapf);

                                System.out.println("Cadastro feito com sucesso!");

                                break;
                            case 2:

                                if (ListaPf.size() > 0) {

                                    for (PessoaFisica cadaPf : ListaPf) {
                                        System.out.println();
                                        System.out.println("Nome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Endereco: " + cadaPf.endereco.logradouro + ", " + cadaPf.endereco.numero);
                                        System.out.println("Data de Nascimento" + cadaPf.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyy")));
                                        System.out.println("Imposto a ser pago" + metodosPf.CalcularImposto(cadaPf.rendimento));
//                                        System.out.println("");
                                        System.out.println("Dogote 0 para continuar");
//                                        scanner.nextLine("");
                                    }

                                    opcaoPF = scanner.nextInt();
                                } else {
                                    System.out.println("Sem lista");
                                }

                                break;
                            case 0:
                                System.out.println("Voltando ao menu anterior");
                                break;
                            default:
                                System.out.println("0,1 ou 2 voce deve digitar pois qualquer outro numero nao vai funcionara");
                                break;
                        }

                    } while (opcaoPF != 0);

                    break;
                case 2:
                    int opcaoPJ;
                    do {

                        System.out.println("Escolha uma opcao: 1 - Cadastrar Pessoa Juuridica / 2 - Listar Pessoa Juridica / 0 - Voltar ao menu anterior ");
                        opcaoPJ = scanner.nextInt();

                        switch (opcaoPJ) {
                            case 1:
                                PessoaJuridica novapj = new PessoaJuridica();
                                Endereco novoEndPJ = new Endereco();

                                System.out.println("Digite o nome da pessoa fisica: ");
                                novapj.nome = scanner.next();

                                System.out.println("Digite o CPNJ : ");
                                novapj.cnpj = scanner.next();

                                System.out.println("Digite o rendimento mensal (Digite somente numero) : ");
                                novapj.rendimento = scanner.nextInt();

                                System.out.println("Digite a data de Nascimento (dd/MM/aaa): ");
                                LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyy"));
                                Period period = Period.between(date, LocalDate.now());

                                if (period.getYears() >= 18) {
                                    System.out.println("A pessoa tem mais de 18 anos, agora pode ser preso");
                                } else {
                                    System.out.println("Que isso meno. Vai ve Cartoon q e melhor...");
                                    break;
                                }

                                System.out.println("Digite o logradouro: ");
                                novoEndPJ.logradouro = scanner.next();

                                System.out.println("Digite o numero: ");
                                novoEndPJ.numero = scanner.next();

                                System.out.println("Este endereco e comercial? S/N: ");
                                String endCom;
                                endCom = scanner.next();

                                if (endCom.equalsIgnoreCase("S")) {
                                    novoEndPJ.enderecoComercial = true;
                                } else {
                                    novoEndPJ.enderecoComercial = false;
                                }

                                novapj.endereco = novoEndPJ;

                                ListaPj.add(novapj);

                                System.out.println("Cadastro feito com sucesso!");

                                break;
                            case 2:

                                if (ListaPj.size() > 0) {

                                    for (PessoaJuridica cadaPj : ListaPj) {
                                        System.out.println();
                                        System.out.println("Nome: " + cadaPj.nome);
                                        System.out.println("CNPJ: " + cadaPj.cnpj);
                                        System.out.println("Endereco: " + cadaPj.endereco.logradouro + ", " + cadaPj.endereco.numero);
                                        System.out.println("Imposto a ser pago" + metodosPj.CalcularImposto(cadaPj.rendimento));
//                                        System.out.println("");
                                        System.out.println("Dogote 0 para continuar");
//                                        scanner.nextLine("");
                                    }

                                    opcaoPJ = scanner.nextInt();
                                } else {
                                    System.out.println("Sem lista");
                                }

                                break;
                            case 0:
                                System.out.println("Voltando ao menu anterior");
                                break;
                            default:
                                System.out.println("0,1 ou 2 voce deve digitar pois qualquer outro numero nao vai funcionara");
                                break;
                        }

                    } while (opcaoPJ != 0);

                    break;

                case 0:
                    System.out.println("Obrigado por utilizar o nosso sistema! Forte abraco! ");
                    break;
                default:
                    System.out.println("0,1 ou 2 voce deve digitar pois qualquer outro numero nao vai funcionara");
                    break;
            }

        } while (opcao != 0);
    }
}






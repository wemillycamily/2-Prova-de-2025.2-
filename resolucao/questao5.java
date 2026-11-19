
public static void extrato(Conta[] vContas, int tamConta, Operacao[] vOp, int tamOp) {
    Scanner sc = new Scanner(System.in);
    System.out.print("ID da conta: ");
    int idConta = sc.nextInt();

    int pos = buscaId(vContas, tamConta, idConta);
    if (pos == -1) {
        System.out.println("Conta não encontrada!");
        return;
    }

    Operacao[] vFiltrado = new Operacao[TAM_OP];
    int tamF = filtraOperacoes(vOp, tamOp, vFiltrado, idConta);

    int inicio = Math.max(0, tamF - 5);

    double saldo = 0;
    for (int i = 0; i < inicio; i++) {
        saldo += vFiltrado[i].valor;
    }

    System.out.println("CONTA N." + idConta);
    System.out.println("CLIENTE: " + vContas[pos].cliente);
    System.out.println("Saldo Anterior: " + formataValor(saldo));

    for (int i = inicio; i < tamF; i++) {
        saldo += vFiltrado[i].valor;
        System.out.printf("%04d %-15s %12s %12s%n",
                vFiltrado[i].id,
                nomeOperacao(vFiltrado[i].tipo),
                formataValor(vFiltrado[i].valor),
                formataValor(saldo));
    }

    System.out.println("Saldo Atual: " + formataValor(saldo));
}

public static String nomeOperacao(char tipo) {
    if (tipo == 'D') return "Depósito";
    if (tipo == 'S') return "Saque";
    return "Transferência";
}

public static String formataValor(double v) {
    char letra = (v >= 0) ? 'C' : 'D';
    return String.format("%.2f%c", Math.abs(v), letra);
}
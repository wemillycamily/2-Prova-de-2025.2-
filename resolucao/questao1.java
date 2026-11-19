public static int cadastrarConta(Conta[] v, int tam) {
    if (tam >= v.length) {
        System.out.println("Vetor cheio!");
        return tam;
    }

    Conta c = lerConta();

    if (buscaId(v, tam, c.id) != -1) {
        System.out.println("ID já cadastrado!");
        return tam;
    }

    if (c.saldo < 0 || c.limite < 0) {
        System.out.println("Saldo e limite não podem ser negativos!");
        return tam;
    }

    v[tam] = c;

    return tam + 1;
}
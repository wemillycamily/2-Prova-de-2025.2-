public static int insertionSortCliente(Conta[] v, int tam) {
    for (int i = 1; i < tam; i++) {
        Conta chave = v[i];
        int j = i - 1;

        while (j >= 0 && v[j].cliente.compareTo(chave.cliente) > 0) {
            v[j + 1] = v[j];
            j--;
        }
        v[j + 1] = chave;
    }
    return tam;
}
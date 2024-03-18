void exibir(List<int> lista)
{
    foreach(var item in lista)
    {
        Console.WriteLine(item);
    }
}


List<int> lista = new List<int>();
int qtdnumeros = 10;

Random gerador = new Random();
int valor;
for(int i =0; i < qtdnumeros; i++)
{
    valor = gerador.Next(100);

    if (!lista.Contains(valor))
    {
        lista.Add(valor);
        lista.Sort();
    }

}
Console.WriteLine("Tamanho da lista " + lista.Count);
exibir(lista);

Console.Write("Digite um valor para exclusão: ");
valor = int.Parse(Console.ReadLine());
lista.Remove(valor);

Console.WriteLine("Tamanho da lista " + lista.Count);
exibir(lista);

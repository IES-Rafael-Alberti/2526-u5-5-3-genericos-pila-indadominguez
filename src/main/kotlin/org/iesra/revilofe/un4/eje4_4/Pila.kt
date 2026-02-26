package org.iesra.revilofe.un4.eje4_4

class Pila<T> : Iterable<T> {
    private val pila: MutableList<T> = mutableListOf()

    fun push(elemento: T) {
        pila.add(elemento)
    }

    fun pop(): T {
        if (isEmpty()) throw NoSuchElementException("La pila está vacía")
        return pila.removeAt(pila.lastIndex)
    }

    fun peek(): T {
        if (isEmpty()) throw NoSuchElementException("La pila está vacía")
        return pila[pila.lastIndex]
    }

    fun isEmpty(): Boolean = pila.isEmpty()

    val size: Int
        get() = pila.size

    override fun toString(): String = "Pila: $pila"

    override fun iterator(): Iterator<T> = object : Iterator<T> {
        private var indice = pila.lastIndex
        override fun hasNext(): Boolean = indice >= 0
        override fun next() : T {
            if (!hasNext()) throw NoSuchElementException()
            return pila[indice--]

        }
    }
}

fun <T> reverse(lista: List<T>): List<T> {
    val pila = Pila<T>()
    val iterador = lista.iterator()

    while (iterador.hasNext()) {
        pila.push(iterador.next())
    }

    val invertida = mutableListOf<T>()
    while (!pila.isEmpty()) {
        invertida.add(pila.pop())
    }
    return invertida
}

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

    override fun toString(): String {
        "Pila: $pila"
    }
}


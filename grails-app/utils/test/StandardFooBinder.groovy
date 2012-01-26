package test

class StandardFooBinder {
    static type = CustomFoo

    def bind = {
        def (a, b) = [it.split("\\|")]

        return new CustomFoo(a: b, b: b)
    }

    def asText = {
        return "${it.a}|${it.b}"
    }
}

package calculadora;

public class calculos {

    //crea metodos para las operaciones matematicas

        /**
         * Suma dos números.
         *
         * @param a primer número a sumar. Debe ser una instancia de Number.
         * @param b segundo número a sumar. Debe ser una instancia de Number.
         * @return la suma de a y b.
         * @throws CalculadoraException si a o b no son instancias de Number.
         */
        public static Integer sumar(Object a, Object b) throws CalculadoraException {
            if (!(a instanceof Number) || !(b instanceof Number)) {
                throw new CalculadoraException("Los parametros deben ser numeros");
            } else {
                return ((Number)a).intValue() + ((Number)b).intValue();
            }
        }

        /**
         * Resta dos números.
         *
         * @param a número del que se resta. Debe ser una instancia de Number.
         * @param b número que se resta. Debe ser una instancia de Number.
         * @return la resta de a y b.
         * @throws CalculadoraException si a o b no son instancias de Number.
         */
        public static Integer restar(Object a, Object b) throws CalculadoraException {
            if (!(a instanceof Number) || !(b instanceof Number)) {
                throw new CalculadoraException("Los parametros deben ser numeros");
            } else {
                return ((Number)a).intValue() - ((Number)b).intValue();
            }
        }

        /**
         * Multiplica dos números.
         *
         * @param a primer número a multiplicar. Debe ser una instancia de Number.
         * @param b segundo número a multiplicar. Debe ser una instancia de Number.
         * @return el producto de a y b.
         * @throws CalculadoraException si a o b no son instancias de Number.
         */
        public static Integer multiplicar(Object a, Object b) throws CalculadoraException {
            if (!(a instanceof Number) || !(b instanceof Number)) {
                throw new CalculadoraException("Los parametros deben ser numeros");
            } else {
                return ((Number)a).intValue() * ((Number)b).intValue();
            }
        }

        /**
         * Divide dos números.
         *
         * @param a número que se divide. Debe ser una instancia de Number.
         * @param b número por el que se divide. Debe ser una instancia de Number.
         * @return el cociente de a y b.
         * @throws CalculadoraException si a o b no son instancias de Number, o si b es cero.
         */
        public static Integer dividir(Object a, Object b) throws CalculadoraException{
            if (!(a instanceof Number) || !(b instanceof Number)) {
                throw new CalculadoraException("Los parametros deben ser numeros");
            } else {
                if (((Number)b).intValue() == 0) {
                    throw new CalculadoraException("No se puede dividir por cero");
                } else {
                    return ((Number)a).intValue() / ((Number)b).intValue();
                }
            }
        }
    }




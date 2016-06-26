package gerenciadeequipamentos

class Armazem {
    String nome
    int areaUtil
    int lotacao
    boolean cheio
    static constraints = {
        nome null: false
        nome blank: false

    }


}

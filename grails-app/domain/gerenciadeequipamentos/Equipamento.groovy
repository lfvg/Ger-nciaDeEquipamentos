package gerenciadeequipamentos

//-Dgeb.env=chrome test-app

class Equipamento {
    String nome
    String status
    String localizacao
    Date data
    static constraints = {

        status blank: false
        localizacao blank: false
        nome blank: false
        data blank: false
        data null: false
    }
    static mapping = {
        sort "data"
        sort data: "asc"
    }
}
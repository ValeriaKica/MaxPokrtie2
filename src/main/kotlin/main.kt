import kotlin.math.max

const val TYPE_1 = "Maestro"
const val TYPE_2 = "MasterCard"
const val MAXAMOUNT_TYPE_1 = 75000//максимальный лимит 75 000
const val FIXCOMMISSION_TYPE_1 = 20//
const val COMMISSIONPERCENTAGE_TYPE_1 = 0.006//
const val TYPE_3 = "Visa"
const val TYPE_4 = "Мир"
const val FIXCOMMISSION_TYPE_3 = 35//
const val COMMISSIONPERCENTAGE_TYPE_3 = 0.0075//
const val TYPE_5 = "VK Pay"
const val COMMISSIONPERCENTAGE_TYPE_5 = 0//
const val ERROR_TYPE = -1//не известный тип карты
const val ERROR_LIMIT = -2//привышение лимита

fun comission(typeCard: String , transfer: Int, previous: Int) : Int {
    if(transfer > 150_000 || transfer + previous > 600_000 ){//лимиты на суммы перевода за сутки и за месяц
        return ERROR_LIMIT
    }
    if (typeCard == TYPE_5 && (transfer > 15_000 || transfer + previous > 40_000)) {
            return ERROR_LIMIT
    }
    return when(typeCard){
        TYPE_1,TYPE_2->if (transfer+previous <= MAXAMOUNT_TYPE_1) 0 else (transfer * COMMISSIONPERCENTAGE_TYPE_1).toInt() + FIXCOMMISSION_TYPE_1
        TYPE_3,TYPE_4 -> max(FIXCOMMISSION_TYPE_3,(transfer * COMMISSIONPERCENTAGE_TYPE_3).toInt())//если комиссия меньше 35 то будет 35,если больше 35 то % выражения
        TYPE_5 -> COMMISSIONPERCENTAGE_TYPE_5

        else -> ERROR_TYPE
    }
}
fun main(){
    val comissionEnd =comission(TYPE_1,160_000,0)
    println("Сумма комиссии составит: $comissionEnd руб.")
}
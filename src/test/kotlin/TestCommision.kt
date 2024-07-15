import org.junit.Test

import org.junit.Assert.*

class TestCommision {

    @Test
    fun typecard() {
        val  typeCard = "SBOL"
        val transfer = 30000
        val previous = 0

        val result = comission(typeCard,transfer,previous)

        assertEquals(ERROR_TYPE,result)
    }
    @Test
    fun comisionVisa() {
        val  typeCard = "Visa"
        val transfer = 10000
        val previous = 0

        val result = comission(typeCard,transfer,previous)

        assertEquals(75,result)
    }
    @Test
    fun comisionVisamin() {
        val  typeCard = "Visa"
        val transfer = 300
        val previous = 0

        val result = comission(typeCard,transfer,previous)

        assertEquals(35,result)
    }

    @Test
    fun comisionVisaDay() {
        val  typeCard = "Visa"
        val transfer = 160_000
        val previous = 0

        val result = comission(typeCard,transfer,previous)

        assertEquals(ERROR_LIMIT,result)
    }
    @Test
    fun comisionVisaMesec() {
        val  typeCard = "Visa"
        val transfer = 140_000
        val previous = 570_000

        val result = comission(typeCard,transfer,previous)

        assertEquals(ERROR_LIMIT,result)
    }



    @Test
    fun comisionVk() {
        val  typeCard = "VK Pay"
        val transfer = 10000
        val previous = 0

        val result = comission(typeCard,transfer,previous)

        assertEquals(COMMISSIONPERCENTAGE_TYPE_5,result)
    }
    @Test
    fun comisionVkDay() {
        val  typeCard = "VK Pay"
        val transfer = 16000
        val previous = 0

        val result = comission(typeCard,transfer,previous)

        assertEquals(ERROR_LIMIT,result)
    }
    @Test
    fun comisionVkDay2() {
        val  typeCard = "VK Pay"
        val transfer = 15000
        val previous = 0

        val result = comission(typeCard,transfer,previous)

        assertEquals(0,result)
    }


    @Test
    fun comisionVkMesec() {
        val  typeCard = "VK Pay"
        val transfer = 14000
        val previous = 36000

        val result = comission(typeCard,transfer,previous)

        assertEquals(ERROR_LIMIT,result)
    }
    @Test
    fun comisionVkMesec2() {
        val  typeCard = "VK Pay"
        val transfer = 4000
        val previous = 36000

        val result = comission(typeCard,transfer,previous)

        assertEquals(0,result)
    }
    @Test
    fun comisionMaestro() {
        val  typeCard = "Maestro"
        val transfer = 10_000
        val previous = 50_000

        val result = comission(typeCard,transfer,previous)

        assertEquals(0,result)
    }
    @Test
    fun comisionMaestro2() {
        val  typeCard = "Maestro"
        val transfer = 10_000
        val previous = 75_000

        val result = comission(typeCard,transfer,previous)

        assertEquals(80,result)
    }





}
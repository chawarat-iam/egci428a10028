package com.example.egci428a10028
import com.example.comegci428a10028.City
object DataProvider {
    private val data = ArrayList<City>()
    fun getData(): ArrayList<City>{
        return data
    }
    init {
        data.add(City("Phuket", "Phuket, a rainforested, mountainous island in the Andaman Sea, has some of Thailand’s most popular beaches, mainly situated along the clear waters of the western shore. The island is home to many high-end seaside resorts, spas and restaurants. Phuket City, the capital, has old shophouses and busy markets. ", "Southern part", "phuket"))
        data.add(City("Bangkok", "Bangkok, Thailand’s capital, is a large city known for ornate shrines and vibrant street life. The boat-filled Chao Phraya River feeds its network of canals, flowing past the Rattanakosin royal district, home to opulent Grand Palace and its sacred Wat Phra Kaew Temple. Nearby is Wat Pho Temple with an enormous reclining Buddha and, on the opposite shore, Wat Arun Temple with its steep steps and Khmer-style spire.", "Central part", "bangkok"))
        data.add(City("ChiangMai", "Chiang Mai is a city in mountainous northern Thailand. Founded in 1296, it was capital of the independent Lanna Kingdom until 1558. Its Old City area still retains vestiges of walls and moats from its history as a cultural and religious center. It’s also home to hundreds of elaborate Buddhist temples, including 14th-century Wat Phra Singh and 15th-century Wat Chedi Luang, adorned with carved serpents.", "Northern part", "chiangmai"))
        data.add(City("Pattaya", "Pattaya is a city on Thailand’s eastern Gulf coast known for its beaches. A quiet fishing village as recently as the 1960s, it’s now lined with resort hotels, high-rise condos, shopping malls, cabaret bars and 24-hour clubs. Nearby, hillside Wat Phra Yai Temple features an 18m-tall golden Buddha. The area also features several designer golf courses, some with views of Pattaya Bay.", "Central part", "pattaya"))
    }
    fun randomCity(): ArrayList<City>{
        val rd = (1..4).random()
        val rdCity = data[rd]
        data.add(rdCity)
        return data
    }
}
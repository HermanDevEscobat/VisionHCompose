package com.example.visionhcompose.class_data

data class DahuaDevice(
    val name: String,
    val model: String,
    val serialNumber: String,
    val imageUrl: String // Предполагается, что изображение устройства загружается по URL
) {
    // Дополнительные свойства и методы могут быть добавлены в зависимости от потребностей

    // Метод для отображения подробной информации об устройстве
    fun displayDeviceInfo() {
        println("Device Name: $name")
        println("Model: $model")
        println("Serial Number: $serialNumber")
        // Дополнительные поля, если они есть
    }

    // Пример метода для обновления изображения устройства
//    fun updateDeviceImage(newImageUrl: String) {
//        imageUrl = newImageUrl
//        println("Device image updated")
//    }
}

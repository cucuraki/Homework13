package com.example.homework13

import com.squareup.moshi.Json

data class Data(
    val id: String,
    val projectId: String,
    val equipmentId: String,
    val status: String,
    val requestedBy: String,
    val acceptedBy: String?,
    val author: String,
    val category: String,
    val locations: Locations,
    val filters: List<Filters>,
    val type: String,
    val organization: String,
    val address: String,
    val startDate: String,
    val endDate: String,
    val description: String,
    val prolongDates: List<String> ,
    val releaseDates: List<String> ,
    val isDummy: Boolean,
    val hasDriver: Boolean,
    val overwriteDate: String?,
    val metaInfo: String? ,
    val warehouseId: String?,
    val rentalDescription: String?,
    val internalTransportations: InternalTransportations,
    val startDateMilliseconds: Long,
    val endDateMilliseconds: Long,
    val equipment: Equipment
) {


    data class Locations(

        val type: String? = null,
        val coordinates: ArrayList<Double> = arrayListOf()

    )

    data class Value(

        val max: Long,
        val min: Int

    )


    data class Filters(

        val name: String,
        val value: Value

    )


    data class PickUpLocation(

        val type: String,
        val coordinates: List<Double>

    )


    data class DeliveryLocation(

        val type: String,
        val coordinates: List<Double>

    )

    data class InternalTransportations(

        val id: String,
        val projectRequestId: String,
        val pickUpDate: String,
        val deliveryDate: String,
        val description: String?,
        val status: String,
        val startDateOption: String?,
        val endDateOption: String?,
        val pickUpLocation: PickUpLocation,
        val deliveryLocation: DeliveryLocation,
        val provider: String,
        val pickUpLocationAddress: String,
        val deliveryLocationAddress: String,
        val pGroup: String,
        val isOrganizedWithoutSam: Boolean? ,
        val templatePGroup: String,
        val pickUpDateMilliseconds: Long,
        val deliveryDateMilliseconds: Long,
        val startDateOptionMilliseconds: String,
        val endDateOptionMilliseconds: String

    )

    data class Specifications(
        val key: String,
        val value: Any
    ){
        data class Values(val H:String, val L: String, val W: String)
    }

    data class Tag(

        val date: String,
        val authorName: String? ,
        val media: List<String>

    )

    data class Brand(

        val id: String,
        val name: String,
        val createdAt: String

    )


    data class Model(

        val id: String,
        val name: String,
        val createdAt: String,
        val brand: Brand

    )


    data class Category(

        val id: String,
        val name: String,
        @Json(name = " name_de")
        val nameDe: String,
        val createdAt: String,
        val media: List<String>

    )


    data class Structure(

        val id: String,
        val name: String,
        val type: String,
        val color: String

    )

    data class Files(

        val size: String,
        val path: String

    )

    data class EquipmentMedia(

        val id: String,
        val name: String,
        val files: List<Files>,
        val type: String,
        val modelId: String,
        val main: Boolean,
        val modelType: String,
        val createdAt: String

    )

    data class Location(

        var type: String,
        var coordinates: List<Double>

    )
    data class Location2(

        var type: String,
        var coordinates: List<List<List<List<Double>>>>

    )

    data class Telematics(

        var timestamp: Long,
        var eventType: String,
        var projectId: String,
        var equipmentId: String,
        var locationName: String,
        var location: Location2 ,
        var costCenter: String ,
        var lastLatitude: Double,
        var lastLongitude: Double,
        var lastLatLonPrecise: Boolean,
        var lastAddressByLatLon: String

    )


    data class Equipment(

        var id: String,
        var title: String,
        var invNumber: String,
        var categoryId: String,
        var modelId: String,
        var brandId: String,
        var year: Int,
        var specifications: List<Specifications>,
        var weight: Int,
        @Json(name = "additional_specifications")
        val additionalSpecifications: String? ,
        val structureId: String,
        val organizationId: String,
        val beaconType: String?,
        val beaconId: String,
        val beaconVendor: String,
        val RFID: String,
        val dailyPrice: String? ,
        val inactive: String?,
        val tag: Tag,
        val telematicBox: String?,
        val createdAt: String,
        @Json(name = "special_number")
        val specialNumber: String?,
        @Json(name = "last_check")
        val lastCheck: String,
        @Json(name = "next_check")
        val nextCheck: String,
        @Json(name = "responsible_person")
        val responsiblePerson: String?,
        @Json(name = "test_type")
        val testType: String? ,
        @Json(name = "unique_equipment_id")
        val uniqueEquipmentId: String,
        @Json(name = "bgl_number")
        val bglNumber: String,
        @Json(name = "serial_number")
        val serialNumber: String?,
        val inventory: String?,
        val warehouseId: String,
        val trackingTag: String?,
        val workingHours: String,
        @Json(name = "navaris_criteria")
        val navarisCriteria: String,
        @Json(name = "dont_send_to_as400")
        val dontSendToAs400: Boolean,
        val model: Model,
        val brand: Brand,
        val category: Category,
        val structure: Structure,
        val wareHouse: String? ,
        val equipmentMedia: List<EquipmentMedia> ,
        val telematics: List<Telematics>,
        val isMoving: Boolean
    )
}

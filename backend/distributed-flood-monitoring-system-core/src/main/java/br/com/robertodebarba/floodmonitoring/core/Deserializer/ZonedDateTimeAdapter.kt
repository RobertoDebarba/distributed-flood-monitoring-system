package br.com.robertodebarba.floodmonitoring.core.Deserializer

import com.google.gson.*
import java.lang.reflect.Type
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class ZonedDateTimeAdapter : JsonSerializer<ZonedDateTime>, JsonDeserializer<ZonedDateTime>{
	override fun serialize(src: ZonedDateTime?, p1: Type?, p2: JsonSerializationContext?): JsonElement {
		return JsonPrimitive(FORMATTER.format(src))
	}

	val FORMATTER : DateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME

    override fun deserialize(element: JsonElement?, p1: Type?, p2: JsonDeserializationContext?): ZonedDateTime {
		return FORMATTER.parse(element?.getAsString(), ZonedDateTime::from)
    }

}
package br.com.robertodebarba.floodmonitoring.api

import java.lang.RuntimeException

class IllegalApiArgumentException(message: String) : RuntimeException(message)
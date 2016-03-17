class java::java8 {
    package { "python-software-properties":
        ensure  => installed,
    }

    apt::ppa { "ppa:openjdk-r/ppa":}

    package { "openjdk-8-jdk":
        ensure  => installed,
        require => Apt::Ppa["ppa:openjdk-r/ppa"],
    }
}
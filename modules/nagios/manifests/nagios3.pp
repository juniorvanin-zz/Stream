class nagios::nagios3 {
    package { "nagios3":
        ensure  => installed,
    }
}
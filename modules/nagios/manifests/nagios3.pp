class nagios::nagios3 {
    package { "nagios3":
        ensure  => installed,
    }

    service { "nagios":
        name        => nagios3,
        ensure      => running,
        enable      => true,
        hasstatus   => true,
        hasrestart  => true,
        require     => Package["nagios3"],
    }
}
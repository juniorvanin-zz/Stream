class stream::nagios inherits stream {
    include stream::params

    class {"nagios::nagios3":}

    nagios::bootstrap { $stream::params::nagios['user']:
        password  => $stream::params::nagios['password'],
    }

    file { "/etc/nagios3/conf.d/stream.cfg":
        owner   => nagios,
        group   => nagios,
        content => template("stream/stream.cfg"),
        notify  => Service["nagios"],
    }
}
define nagios::bootstrap($user = $title, $password) {
    Class['nagios::nagios3'] -> Nagios::Bootstrap[$title]

    exec { "create-$title-user":
        command => "/usr/bin/htpasswd -c -b /etc/nagios3/htpasswd.users $user $password",
        require => Package["apache2-utils"],
    }

    package {"apache2-utils":
        ensure => installed,
    }
}
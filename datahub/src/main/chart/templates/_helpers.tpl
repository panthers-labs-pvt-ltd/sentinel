{{- define "datahub-chart.name" -}}
{{ .Chart.Name }}
{{- end }}

{{- define "datahub-chart.fullname" -}}
{{ include "datahub-chart.name" . }}-{{ .Release.Name }}
{{- end }}
